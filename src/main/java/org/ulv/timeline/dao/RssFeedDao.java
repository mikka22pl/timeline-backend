package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.rss.RssFeed;

@Component
public class RssFeedDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<RssFeed> getRssFeeds(Integer id) {
		return sqlSession.selectList("org.ulv.timeline.dao.RssFeedDao.getRssFeed", id);
	}
	
	public List<RssFeed> getRssFeedsWithChildrenCounted(Integer feedId) {
		return sqlSession.selectList("org.ulv.timeline.dao.RssFeedDao.getRssFeedWithChildrenCounted", feedId);
	}
	
	public void addRssFeed(RssFeed feed) {
		sqlSession.insert("org.ulv.timeline.dao.RssFeedDao.addRssFeed", feed);
	}
}
