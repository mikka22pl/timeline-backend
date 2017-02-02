package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.rss.RssFeed;

public interface RssFeedService {

	List<RssFeed> getRssFeeds();
	
	RssFeed getRssFeedById(Integer id);
	
	List<RssEntry> getEntries(RssEntry entry, boolean draft);
	
	void saveFeed(RssFeed feed);
	
	void addEntry(RssEntry entry, boolean draft);
	
	int getAndAddDraftEntries(RssFeed rssFeed);
	
	void doneEntry(RssEntry entry);
	
	void acceptDraftEntry(RssEntry entry);
}