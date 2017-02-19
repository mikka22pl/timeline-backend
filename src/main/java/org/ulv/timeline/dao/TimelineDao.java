package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.AssignedItem;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.model.timeline.Timeline;

@Component
public class TimelineDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Timeline> getTimelines(RssEntry entry) {
		return sqlSession.selectList("org.ulv.timeline.dao.TimelineDao.getTimeline", entry);
	}
	
	public void assignArticle(AssignedItem assignedItem) {
		sqlSession.insert("org.ulv.timeline.dao.TimelineDao.assignArticle", assignedItem);
	}
	
	public void removeTimeline(AssignedItem assignedItem) {
		sqlSession.delete("org.ulv.timeline.dao.TimelineDao.removeTimeline", assignedItem);
	}
	
	public void addTimeline(Timeline timeline) {
		sqlSession.insert("org.ulv.timeline.dao.TimelineDao.addTimeline", timeline);
	}
}
