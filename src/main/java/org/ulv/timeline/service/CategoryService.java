package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.model.Category;

public interface CategoryService {

	List<Category> getCategories();
	
	Category getCategory(String name);
	
	void saveCategory(Category category);
	
	Category saveOrFind(Category category);
}
