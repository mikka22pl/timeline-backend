package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.rss.RssFeed;

public interface RssFeedService {

	List<RssFeed> getRssFeeds(boolean withCounts);
	
	RssFeed getRssFeedById(Integer id);
	
	List<RssEntry> getEntries(RssEntry entry, boolean draft);
	
	List<RssEntry> getEntriesByTagId(Integer tagId);
	
	void saveFeed(RssFeed feed);
	
	void addEntry(RssEntry entry, boolean draft);
	
	int getAndAddDraftEntries(RssFeed rssFeed);
	
	void acceptEntry(RssEntry entry);
	
	void acceptDraftEntry(RssEntry entry);
	void rejectDraftEntry(RssEntry entry);
	
	RssEntry saveEntry(RssEntry entry) throws TimelineException;
}
