package org.ulv.timeline.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.service.TagService;

@RestController
@RequestMapping("timeline")
public class TagController {

	private static final Logger log = LoggerFactory.getLogger(TagController.class);
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping(value="tags/{languageId}", method=RequestMethod.GET)
	public ResponseEntity<List<Tag>> getTags(@PathVariable Integer languageId) {
		log.info("--> getTags({})", languageId);
		
		List<Tag> tags = tagService.getTags(languageId);
		
		return new ResponseEntity<List<Tag>>(tags, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value="tag/{name}/{languageId}", method=RequestMethod.GET)
	public ResponseEntity<Tag> getTagByName(
			@PathVariable String name,
			@PathVariable Integer languageId) {
		
		log.info("--> getTagByName({})", name);
		
		Tag tag = tagService.getTagByName(name, languageId);
		
		return new ResponseEntity<Tag>(tag, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tag/save", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Integer> saveTag(
			@RequestBody Tag tag) {
		
		try {
			boolean isNew = tag.isNew();
			tagService.saveTag(tag);
			if (isNew)
				return new ResponseEntity<Integer>(tag.getId(), HeadersUtil.HEADERS, HttpStatus.CREATED);
			else
				return new ResponseEntity<Integer>(HeadersUtil.HEADERS, HttpStatus.NO_CONTENT);
		} catch (TimelineException e) {
			return new ResponseEntity<Integer>(HeadersUtil.HEADERS, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/tags/linked", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<List<Tag>> getTagsByArticlesTags(@RequestBody List<Tag> tags) {
		
		List<Tag> linkedTags = tagService.getTagsByArticlesTags(tags);
		
		return new ResponseEntity<List<Tag>>(linkedTags, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
