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
	
	public List<Tag> getTags() {
		return sqlSession.selectList("getTag");
	}
	
	public Tag getTagByName(String name) {
		return sqlSession.selectOne("getTagByName", name);
	}
	
	public int addTag(Tag tag) {
		return sqlSession.insert("addTag", tag);
	}
	
	public List<Tag> getTagsByArticlesTags(RssEntry rssEntry) {
		return sqlSession.selectList("getTagsByArticlesTags", rssEntry);
	}
}
