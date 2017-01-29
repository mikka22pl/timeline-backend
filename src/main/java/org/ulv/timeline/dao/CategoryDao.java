package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.Category;

@Component
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Category> getCategories() {
		return sqlSession.selectList("getCategory");
	}
	
	public Category getCategory(Category category) {
		return sqlSession.selectOne("getCategory", category);
	}
	
	public int addCategory(Category category) {
		return sqlSession.insert("addCategory", category);
	}
}
