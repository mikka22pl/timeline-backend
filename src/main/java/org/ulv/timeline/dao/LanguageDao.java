package org.ulv.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.timeline.model.Language;

@Component
public class LanguageDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Language> getLanguages() {
		return this.sqlSession.selectList("getLanguage");
	}
}