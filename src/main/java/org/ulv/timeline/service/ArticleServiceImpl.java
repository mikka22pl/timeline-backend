package org.ulv.timeline.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ulv.timeline.dao.ArticleDao;
import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Article;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;

	@Override
	public List<Article> getArticles() {
		return articleDao.getArticles(null);
	}
	
	@Override
	public List<Article> getArticlesByTagId(Integer tagId) {
		return articleDao.getArticlesByTagId(tagId);
	}

	@Override
	public Article getArticleById(Integer id) {
		Article article = new Article(id);
		List<Article> list = articleDao.getArticles(article);
		if (CollectionUtils.isNotEmpty(list)) {
			if (list.size() == 1) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveArticle(Article article) throws TimelineException {
		log.info("--> saveArticle(article {})", article);
		int res = 0;
		if (article.isNew()) {
			
			categoryService.saveOrFind(article.getCategory());
			List<Integer> tagsIds = tagService.saveTags(article.getTags());
			
			res = articleDao.addArticle(article);
			
			articleDao.assignTags(article);
		} else { 

		}
		if (res == 0) {
			throw new TimelineException("Saving Article failed");
		}
	}

}
