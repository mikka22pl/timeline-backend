package org.ulv.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.dao.TimelineDao;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.timeline.Timeline;

@Service("timelineService")
public class TimelineServiceImpl implements TimelineService {

	@Autowired
	private TimelineDao timelineDao;
	
	@Override
	public List<Timeline> getTimelines() {
		return timelineDao.getTimelines();
	}

	@Override
	public void assignArticle(List<Integer> timelineIds, RssEntry rssEntry) {
		for (Integer id : timelineIds) {
			AssignedItem assignedItem = new AssignedItem();
			assignedItem.setBaseId(id);
			assignedItem.setAssigneeId(rssEntry.getId());
			
			timelineDao.assignArticle(assignedItem);
		}
	}

}
