package org.ulv.timeline.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.dao.TagDao;
import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.model.rss.RssEntry;

@Service("tagService")
public class TagServiceImpl implements TagService {
	
	private static final Logger log = LoggerFactory.getLogger(TagService.class);

	@Autowired
	private TagDao tagDao;
	
	@Override
	public List<Tag> getTags(Integer languageId) {
		log.info("--> getTags({})", languageId);
		return tagDao.getTags(languageId);
	}

	@Override
	public Tag getTagByName(String name, Integer languageId) {
		log.info("--> getTagByName({}, {})", name, languageId);
		Tag tag = new Tag(name);
		tag.getLanguage().setId(languageId);
		return tagDao.getTagByName(tag);
	}

	@Override
	public void saveTag(Tag tag) throws TimelineException {
		log.info("--> saveTag(Tag {})", tag);
		int res = 0;
		if (tag.isNew()) {
			res = tagDao.addTag(tag);
		} else {
			res = 1;
		}
		if (res == 0) {
			throw new TimelineException("Saving tag failed");
		}
	}

	@Override
	public void saveOrFind(Tag tag) throws TimelineException {
		Tag dbTag = getTagByName(tag.getName(), tag.getLanguage().getId());
		if (dbTag == null) {
			saveTag(tag);
		} else {
			tag.setId(dbTag.getId());
		}
	}

	@Override
	public List<Integer> saveTags(List<Tag> tags, Integer languageId) throws TimelineException {
		log.info("--> saveTags({})", languageId);
		List<Integer> ids = new ArrayList<Integer>();
		for (Tag tag : tags) {
			tag.getLanguage().setId(languageId);
			saveOrFind(tag);
			if (tag.getId() == null) {
				Tag dbTag = getTagByName(tag.getName(), languageId);
				tag.setId(dbTag.getId());
			}
			ids.add(tag.getId());
		}
		return ids;
	}

	@Override
	public List<Tag> getTagsByArticlesTags(List<Tag> tags) {
		RssEntry entry = new RssEntry();
		entry.setTags(tags);
		
		return tagDao.getTagsByArticlesTags(entry);
	}
}
