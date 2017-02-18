package org.ulv.timeline.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.model.Category;
import org.ulv.timeline.service.CategoryService;

@RestController
@RequestMapping("timeline")
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="categories", method=RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategories() {
		log.info("--> getCategories()");
		
		List<Category> categories = categoryService.getCategories();
		
		return new ResponseEntity<List<Category>>(categories, HeadersUtil.HEADERS, HttpStatus.OK);
	}

	@RequestMapping(value="category/{name}", method=RequestMethod.GET)
	public ResponseEntity<Category> getCategory(@PathVariable String name) {
		log.info("--> getCategory({})", name);
		
		Category category = categoryService.getCategory(name);
		
		return new ResponseEntity<Category>(category, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
