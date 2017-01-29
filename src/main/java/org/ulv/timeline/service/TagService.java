package org.ulv.timeline.service;

import java.util.List;

import org.ulv.timeline.exceptions.TimelineException;
import org.ulv.timeline.model.Tag;

public interface TagService {

	List<Tag> getTags();
	
	Tag getTagByName(String name);
	
	void saveTag(Tag tag) throws TimelineException;
	
	void saveOrFind(Tag tag) throws TimelineException;
	
	List<Integer> saveTags(List<Tag> tags) throws TimelineException;
}
