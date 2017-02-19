package org.ulv.timeline.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.timeline.Timeline;

public interface TimelineService {

	List<Timeline> getTimelines();
	
	List<Timeline> getEntryTimelines(Integer entryId);
	
	void assignArticle(List<Integer> timelineIds, RssEntry rssEntry);
	
	void saveTimeline(Timeline timeline);
	
	void removeTimeline(AssignedItem assignedItem);
}
