package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.Article;

@Component
public class ArticleDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Article> getArticles(Article article) {
		return sqlSession.selectList("getArticle", article);
	}
	
	public List<Article> getArticlesByTagId(Integer tagId) {
		return sqlSession.selectList("getArticleByTagId", tagId);
	}
	
	public int addArticle(Article article) {
		return sqlSession.insert("addArticle", article);
	}
	
	public void assignTags(Article article) {
		sqlSession.insert("assignTags", article);
	}
}
