package org.ulv.timeline.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.timeline.dao.LanguageDao;
import org.ulv.timeline.model.Language;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {
	
	private static final Logger log = LoggerFactory.getLogger(LanguageServiceImpl.class);

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public List<Language> getLanguages() {
		log.info("--> getLanguages()");
		return languageDao.getLanguages();
	}	
}
