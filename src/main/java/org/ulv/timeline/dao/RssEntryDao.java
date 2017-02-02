package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.rss.RssEntry;

@Component
public class RssEntryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<RssEntry> getDraftEntries(RssEntry entry) {
		return sqlSession.selectList("org.ulv.timeline.dao.RssEntryDao.getRssEntry", entry);
	}
	
	public void addDraftEntry(RssEntry entry) {
		sqlSession.insert("org.ulv.timeline.dao.RssEntryDao.addDraftEntry", entry);
	}
	
	public void doneDraftEntry(RssEntry entry) {
		sqlSession.update("org.ulv.timeline.dao.RssEntryDao.doneDraftEntry", entry);
	}
	
	public void acceptDraftEntry(RssEntry entry) {
		sqlSession.insert("org.ulv.timeline.dao.RssEntryDao.acceptDraftEntry", entry);
	}
}
