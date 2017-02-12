package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Tag;

public interface TagService {

	List<Tag> getTags(Integer languageId);
	
	Tag getTagByName(String name, Integer languageId);
	
	void saveTag(Tag tag) throws TimelineException;
	
	void saveOrFind(Tag tag) throws TimelineException;
	
	List<Integer> saveTags(List<Tag> tags, Integer languageId) throws TimelineException;
	
	List<Tag> getTagsByArticlesTags(List<Tag> tags);
}
