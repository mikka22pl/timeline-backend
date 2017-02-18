package org.ulv.timeline.model.builders;

import org.ulv.timeline.model.Tag;

public class TagBuilder {

	private Tag instance;
	
	public TagBuilder() {
		instance = new Tag();
	}
	
	public TagBuilder withId(Integer id) {
		instance.setId(id);
		return this;
	}
	
	public TagBuilder withName(String name) {
		instance.setName(name);
		return this;
	}
	
	public Tag build() {
		return instance;
	}
}
