package org.ulv.timeline.service;

import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Article;

import java.util.List;

public interface ArticleService {

	List<Article> getArticles();
	
	List<Article> getArticlesByTagId(Integer tagId);
	
	Article getArticleById(Integer id);
	
	void saveArticle(Article article) throws TimelineException;
}
