package org.ulv.timeline.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Article;
import org.ulv.timeline.model.rss.RssEntry;
import org.ulv.timeline.service.ArticleService;
import org.ulv.timeline.service.RssFeedService;

@RestController
@RequestMapping("timeline")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private RssFeedService rssFeedService;
	
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public ResponseEntity<List<Article>> getArticles() {
		
		List<Article> articles = articleService.getArticles();
		return new ResponseEntity<List<Article>>(articles, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value="/articles/{tagId}", method=RequestMethod.GET)
	public ResponseEntity<List<RssEntry>> getArticlesByTagId(@PathVariable Integer tagId) {

//		List<Article> articles = articleService.getArticlesByTagId(tagId);
//		return new ResponseEntity<List<Article>>(articles, HeadersUtil.HEADERS, HttpStatus.OK);
		List<RssEntry> entries = rssFeedService.getEntriesByTagId(tagId);
		return new ResponseEntity<List<RssEntry>>(entries, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/article/save", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Integer> saveArticle(
			@RequestBody Article article) {
		
		try {
			boolean isNew = article.isNew();
			articleService.saveArticle(article);
			if (isNew)
				return new ResponseEntity<Integer>(article.getId(), HeadersUtil.HEADERS, HttpStatus.CREATED);
			else
				return new ResponseEntity<Integer>(HeadersUtil.HEADERS, HttpStatus.NO_CONTENT);
		} catch (TimelineException e) {
			return new ResponseEntity<Integer>(HeadersUtil.HEADERS, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="/article/{id}", method=RequestMethod.GET)
	public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
		
		Article article = articleService.getArticleById(id);
		
		return new ResponseEntity<Article>(article, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
