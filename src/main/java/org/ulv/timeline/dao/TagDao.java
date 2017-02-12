package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.model.rss.RssEntry;

@Component
public class TagDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Tag> getTags(Integer languageId) {
		return sqlSession.selectList("org.ulv.timeline.dao.TagDao.getTag", languageId);
	}
	
	public Tag getTagByName(Tag tag) {
		return sqlSession.selectOne("org.ulv.timeline.dao.TagDao.getTagByName", tag);
	}
	
	public int addTag(Tag tag) {
		return sqlSession.insert("org.ulv.timeline.dao.TagDao.addTag", tag);
	}
	
	public List<Tag> getTagsByArticlesTags(RssEntry rssEntry) {
		return sqlSession.selectList("org.ulv.timeline.dao.TagDao.getTagsByArticlesTags", rssEntry);
	}
	
	public List<Tag> getEntryTags(Integer entryId) {
		return sqlSession.selectList("org.ulv.timeline.dao.TagDao.getEntryTags", entryId);
	}
}
