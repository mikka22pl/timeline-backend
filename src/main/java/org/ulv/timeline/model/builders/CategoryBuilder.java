package org.ulv.timeline.model.builders;

import org.ulv.timeline.model.Category;

public class CategoryBuilder {

	private Category instance;
	
	public CategoryBuilder() {
		instance = new Category();
	}
	
	public CategoryBuilder withId(Integer id) {
		instance.setId(id);
		return this;
	}
	
	public CategoryBuilder withName(String name) {
		instance.setName(name);
		return this;
	}
	
	public Category build() {
		return instance;
	}
}
