package org.ulv.timeline.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.dao.TimelineDao;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.timeline.Timeline;

@Service("timelineService")
public class TimelineServiceImpl implements TimelineService {
	private static final Logger log = LoggerFactory.getLogger(TimelineServiceImpl.class);

	@Autowired
	private TimelineDao timelineDao;
	
	@Override
	public List<Timeline> getTimelines() {
		log.info("--> getTimelines()");
		return timelineDao.getTimelines(null);
	}

	@Override
	public List<Timeline> getEntryTimelines(Integer entryId) {
		log.info("--> getEntryTimelines({})", entryId);
		RssEntry entry = new RssEntry(entryId);
		return timelineDao.getTimelines(entry);
	}

	@Override
	public void assignArticle(List<Integer> timelineIds, RssEntry rssEntry) {
		log.info("--> assignArticle()");
		for (Integer id : timelineIds) {
			AssignedItem assignedItem = new AssignedItem();
			assignedItem.setBaseId(id);
			assignedItem.setAssigneeId(rssEntry.getId());
			
			timelineDao.assignArticle(assignedItem);
		}
	}

	@Override
	public void saveTimeline(Timeline timeline) {
		log.info("--> saveTimeline({})", timeline);
		if (timeline.isNew()) {
			timelineDao.addTimeline(timeline);
		}
	}

	@Override
	public void removeTimeline(AssignedItem assignedItem) {
		log.info("--> removeTimeline({})", assignedItem);
		timelineDao.removeTimeline(assignedItem);
	}
	
	
}