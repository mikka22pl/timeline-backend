package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.timeline.Timeline;

public interface TimelineService {

	List<Timeline> getTimelines();
	
	void assignArticle(List<Integer> timelineIds, RssEntry rssEntry);
	
	
}