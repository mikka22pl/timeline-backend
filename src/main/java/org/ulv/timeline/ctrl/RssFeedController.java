package org.ulv.timeline.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.rss.RssFeed;
import org.ulv.timeline.service.ArticleServiceImpl;
import org.ulv.timeline.service.RssFeedService;

@Controller
@RequestMapping("timeline")
public class RssFeedController {
	
	private static final Logger log = LoggerFactory.getLogger(RssFeedController.class);

	@Autowired
	private RssFeedService rssFeedService;
	
	@RequestMapping(value="/rss/feeds", method=RequestMethod.GET)
	public ResponseEntity<List<RssFeed>> getRssFeeds() {
		List<RssFeed> feeds = rssFeedService.getRssFeeds(true);
		return new ResponseEntity<List<RssFeed>>(feeds, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/feed/draft/{feedId}", method=RequestMethod.GET)
	public ResponseEntity<RssFeed> feedDraftEntries(
			@PathVariable Integer feedId) {
		
		RssFeed feed = rssFeedService.getRssFeedById(feedId);
		// get first one
		int count = rssFeedService.getAndAddDraftEntries(feed);
		
		RssFeed rssFeed = new RssFeed(feedId);
		rssFeed.setLoadedCount(count);
		
		return new ResponseEntity<RssFeed>(rssFeed, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/feed/save", method=RequestMethod.POST)
	public ResponseEntity<RssFeed> saveFeed(
			@RequestBody RssFeed rssFeed) {
		
		rssFeedService.saveFeed(rssFeed);
		
		return new ResponseEntity<RssFeed>(rssFeed, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	
	
	

	@RequestMapping(value="/rss/entries/draft/{feedId}", method=RequestMethod.GET)
	public ResponseEntity<List<RssEntry>> getDraftEntries(
			@PathVariable Integer feedId) {
		log.info("--> getDraftEntries({})", feedId);

		RssEntry entry = new RssEntry(new RssFeed(feedId));
		List<RssEntry> entries = rssFeedService.getEntries(entry, true);
		
		return new ResponseEntity<List<RssEntry>>(entries, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rss/entries/{feedId}", method=RequestMethod.GET)
	public ResponseEntity<List<RssEntry>> getEntries(
			@PathVariable Integer feedId) {
		log.info("--> getEntries({})", feedId);
		
		RssEntry entry = new RssEntry(new RssFeed(feedId));
		List<RssEntry> entries = rssFeedService.getEntries(entry, false);
		
		return new ResponseEntity<List<RssEntry>>(entries, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rss/entry/done", method=RequestMethod.POST)
	public ResponseEntity<Integer> doneEntry(
			@RequestBody RssEntry rssEntry) {
		
		rssFeedService.acceptDraftEntry(rssEntry);
		
		return new ResponseEntity<Integer>(1, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	

	@RequestMapping(value="/rss/entry/accept", method=RequestMethod.POST)
	public ResponseEntity<RssEntry> acceptDraftEntry(
			@RequestBody RssEntry entry) {

		rssFeedService.acceptDraftEntry(entry);
		
		
		return new ResponseEntity<RssEntry>(entry, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/entry/reject", method=RequestMethod.POST)
	public ResponseEntity<RssEntry> rejectDraftEntry(
			@RequestBody RssEntry entry) {

		rssFeedService.rejectDraftEntry(entry);
		
		
		return new ResponseEntity<RssEntry>(entry, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/entry/save", method=RequestMethod.POST)
	public ResponseEntity<RssEntry> saveEntry(
			@RequestBody RssEntry entry) {
		log.info("--> saveEntry({})", entry);
		try {
			rssFeedService.saveEntry(entry);

			log.info("<-- saveEntry()");
			return new ResponseEntity<RssEntry>(entry, HeadersUtil.HEADERS, HttpStatus.OK);
			
		} catch (TimelineException e) {
			return new ResponseEntity<RssEntry>(HeadersUtil.HEADERS, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
