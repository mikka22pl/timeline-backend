package org.ulv.timeline.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ulv.timeline.dao.RssEntryDao;
import org.ulv.timeline.dao.RssFeedDao;
import org.ulv.timeline.dao.TagDao;
import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.rss.RssFeed;
import org.ulv.timeline.model.timeline.Timeline;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Service("rssFeedService")
public class RssFeedServiceImpl implements RssFeedService {
	
	private static final Logger log = LoggerFactory.getLogger(RssFeedServiceImpl.class);

	@Autowired
	private RssFeedDao feedDao;
	
	@Autowired
	private RssEntryDao entryDao;
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private TimelineService timelineService;
	
	@Override
	public List<RssFeed> getRssFeeds(boolean withCounts) {
		
		return withCounts ? feedDao.getRssFeedsWithChildrenCounted(null) : feedDao.getRssFeeds(null);
	}

	@Override
	public RssFeed getRssFeedById(Integer id) {
		List<RssFeed> list = feedDao.getRssFeeds(id);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		if (list.size() > 1) {
			// TODO throws Exception
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<RssEntry> getEntries(RssEntry entry, boolean draft) {
		log.info("--> getEntries(draft: {})", draft);
		if (draft) {
			return entryDao.getDraftEntries(entry);
		}
		return entryDao.getEntries(entry);
	}


	@Override
	public List<RssEntry> getEntriesByTagId(Integer tagId) {
		log.info("--> getEntriesByTagId(tagId: {})", tagId);
		return entryDao.getRssEntryByTagId(tagId);
	}
	
	@Override
	public void addEntry(RssEntry entry, boolean draft) {
		if (draft) {
			entryDao.addDraftEntry(entry);
		}
	}

	@Override
	public int getAndAddDraftEntries(RssFeed rssFeed) {
		List<RssEntry> newEntries = pullEntries(rssFeed.getId());
		int count = 0;
		for (RssEntry entry : newEntries) {
			try {
				addEntry(entry, true);
				count++;
			} catch (DuplicateKeyException e) {
				log.warn("Saving entry aborted. duplicate key exception. Link: {}", entry.getLink());
			}
		}
		return count;
	}
	
	@Override
	public void acceptEntry(RssEntry entry) {
		entryDao.acceptDraftEntry(entry);
	}

	@Override
	public void saveFeed(RssFeed feed) {
		log.info("--> saveFeed() {}", feed);
		if (feed.isNew()) {
			feedDao.addRssFeed(feed);
		}
	}

	@Override
	public void acceptDraftEntry(RssEntry entry) {
		log.info("--> acceptDraftEntry() {}", entry);
		
		entryDao.acceptDraftEntry(entry);
		entryDao.addEntry(entry);
	}

	@Override
	public void rejectDraftEntry(RssEntry entry) {
		log.info("--> rejectDraftEntry() {}", entry);
		
		entryDao.rejectDraftEntry(entry);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public RssEntry saveEntry(RssEntry entry) throws TimelineException {
		log.info("--> saveEntry() {}", entry);
		
		categoryService.saveOrFind(entry.getCategory());
		Integer languageId = entry.getRssFeed().getDistributor().getLanguage().getId();
		List<Integer> tagsIds = tagService.saveTags(entry.getTags(), languageId);

		// TODO: fix it for update case
		List<Integer> timelineIds = entry.getTimelines().stream()
				.map(Timeline::getId)
				.collect(Collectors.toList());
		timelineService.assignArticle(timelineIds, entry);
		
		/*entryDao.updateEntry(entry);
		try {
			assignTags(entry);
		} catch (DuplicateKeyException e) {
			log.warn("Assigning tags aborted. duplicate key exception.");
		}*/
		
		return entry;
	}

	@Override
	public Map<String, List<Integer>> assignTags(RssEntry entry) {
		log.info("--> assignTags()");

		List<Tag> dbTags = tagDao.getEntryTags(entry.getId());
		HashSet<Integer> dbTagIds = dbTags.stream()
				.map(Tag::getId)
				.collect(Collectors.toCollection(HashSet::new));
		
		Map<Boolean, List<Integer>> saveIds = entry.getTags().stream()
				.map(Tag::getId)
				.collect(Collectors.partitioningBy(id -> !dbTagIds.contains(id)));
	
		List<Integer> removeIds = dbTagIds.stream()
			.filter(id -> !saveIds.get(false).contains(id))
			.collect(Collectors.toList());
		
		removeIds.forEach(id -> entryDao.removeTags(new AssignedItem(entry.getId(), id)));
		if (saveIds.get(true).size() > 0) {
			entryDao.assignTags(entry);
		}
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("SAVED", saveIds.get(true));
		map.put("REMOVED", removeIds);
		return map;
	}

	private List<RssEntry> pullEntries(Integer feedId) {
		RssFeed rssfeed = getRssFeedById(feedId);
		if (rssfeed != null) {
			SyndFeedInput input = new SyndFeedInput();
			try {
				SyndFeed feed = input.build(new XmlReader(new URL(rssfeed.getUrl())));
				
				@SuppressWarnings("unchecked")
				List<SyndEntryImpl> list = feed.getEntries();
				List<RssEntry> entries = new ArrayList<RssEntry>();
				for (SyndEntryImpl entry : list) {
					RssEntry rssentry = new RssEntry(entry.getTitle(), new RssFeed(feedId));
					rssentry.setLink(entry.getLink());
					rssentry.setPubDate(entry.getPublishedDate());
					rssentry.setDescr(entry.getDescription().getValue());
					
					
					System.out.println("entry " + entry);
					
					entries.add(rssentry);
//					System.out.println("entry " + entry.getTitle());
				}
				return entries;
			} catch (IOException | FeedException e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}