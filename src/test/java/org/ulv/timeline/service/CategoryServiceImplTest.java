package org.ulv.timeline.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.timeline.dao.CategoryDao;
import org.ulv.timeline.model.Category;
import org.ulv.timeline.model.builders.CategoryBuilder;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

	@Mock
	private CategoryDao categoryDao;
	
	@InjectMocks
	private CategoryService service = new CategoryServiceImpl();
	
	@Test
	public void should_return_category_by_name() {
		// given
		String name = "lalala";
		Category dbCategory = new CategoryBuilder().withId(1).withName(name).build();
		when(categoryDao.getCategory(any(Category.class))).thenReturn(dbCategory);
		
		// when
		Category category = service.getCategory(name);
		
		// then
		assertThat(category).isNotNull();
		assertThat(category.getName()).isEqualTo(name);
	}
	
	@Test
	public void should_save_new_category() {
		// given
		String name = "lalala";
		Category toSave = new CategoryBuilder().withName(name).build();
		when(categoryDao.addCategory(toSave)).thenReturn(1);
		
		// when
		service.saveCategory(toSave);
		
		// then
		verify(categoryDao).addCategory(toSave);
	}
	
	@Test
	public void should_find_category() {
		// given
		String name = "lalala";
		Category cat = new CategoryBuilder().withName(name).build();
		Category expected = new CategoryBuilder().withId(1).withName(name).build();
		when(categoryDao.getCategory(cat)).thenReturn(expected);
		
		// when
		Category dbCat = service.saveOrFind(cat);
		
		// then
		assertThat(dbCat).isNotNull();
		assertThat(dbCat.getId()).isEqualTo(expected.getId());
		assertThat(dbCat.getName()).isEqualTo(expected.getName());
	}
	
	@Test
	public void should_save_category_if_any_found() {
		// given
		String name = "lalala";
		Category cat = new CategoryBuilder().withName(name).build();
		when(categoryDao.getCategory(cat)).thenReturn(null);
		when(categoryDao.addCategory(cat)).thenReturn(1);
		
		// when
		Category dbCat = service.saveOrFind(cat);
		
		// then
		assertThat(dbCat).isNotNull();
		assertThat(dbCat.getName()).isEqualTo(cat.getName());
	}
}
