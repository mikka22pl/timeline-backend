package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@Override
	public Category getCategory(String name) {
		Category category = new Category(name);
		
		return categoryDao.getCategory(category);
	}

	@Override
	public void saveCategory(Category category) {
		if (category.isNew()) {
			categoryDao.addCategory(category);
		} else {
			
		}
	}

	@Override
	public Category saveOrFind(Category category) {
		Category dbCat = categoryDao.getCategory(category);
		if (dbCat == null) {
			saveCategory(category);
			return category;
		}
		category.setId(dbCat.getId());
		return dbCat;
	}

}
