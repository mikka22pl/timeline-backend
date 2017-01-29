package org.ulv.timeline.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.model.Language;
import org.ulv.timeline.service.LanguageService;

@Controller
@RequestMapping("timeline")
public class LanguageController {

	private static final Logger log = LoggerFactory.getLogger(LanguageController.class);
	
	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(value="languages", method=RequestMethod.GET)
	public ResponseEntity<List<Language>> getLanguages() {
		log.info("--> getLanguages()");
		
		List<Language> languages = languageService.getLanguages();
		
		return new ResponseEntity<List<Language>>(languages, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
