package org.ulv.timeline.ctrl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.rss.RssFeed;
import org.ulv.timeline.service.RssFeedService;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Controller
@RequestMapping("timeline")
public class RssFeedController {

	@Autowired
	private RssFeedService rssFeedService;
	
	@RequestMapping(value="/rss/feeds", method=RequestMethod.GET)
	public ResponseEntity<List<RssFeed>> getRssFeeds() {
		List<RssFeed> feeds = rssFeedService.getRssFeeds();
		return new ResponseEntity<List<RssFeed>>(feeds, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/feed/draft/{feedId}", method=RequestMethod.GET)
	public ResponseEntity<Integer> feedDraftEntries(
			@PathVariable Integer feedId) {
		
		RssFeed feed = rssFeedService.getRssFeedById(feedId);
		// get first one
		int count = rssFeedService.getAndAddDraftEntries(feed);
		
		return new ResponseEntity<Integer>(count, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="/rss/feed/save", method=RequestMethod.POST)
	public ResponseEntity<RssFeed> saveFeed(
			@RequestBody RssFeed rssFeed) {
		
		rssFeedService.saveFeed(rssFeed);
		
		return new ResponseEntity<RssFeed>(rssFeed, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	
	
	

	@RequestMapping(value="/rss/entries/draft/{feedId}", method=RequestMethod.GET)
	public ResponseEntity<List<RssEntry>> getEntries(
			@PathVariable Integer feedId) {

		RssEntry entry = new RssEntry(new RssFeed(feedId));
		List<RssEntry> entries = rssFeedService.getEntries(entry, true);
		
		return new ResponseEntity<List<RssEntry>>(entries, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rss/entry/done", method=RequestMethod.POST)
	public ResponseEntity<Integer> doneEntry(
			@RequestBody RssEntry rssEntry) {
		
		rssFeedService.doneEntry(rssEntry);
		
		return new ResponseEntity<Integer>(1, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	

	@RequestMapping(value="/rss/entry/accept", method=RequestMethod.POST)
	public ResponseEntity<RssEntry> acceptDraftEntry(
			@RequestBody RssEntry entry) {

		rssFeedService.acceptDraftEntry(entry);
		
		
		return new ResponseEntity<RssEntry>(entry, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	
}
