package org.ulv.timeline.model;

import java.util.ArrayList;
import java.util.List;

import org.ulv.base.model.NamedEntity;

public class BaseArticle extends NamedEntity {

	private static final long serialVersionUID = -5908572121968348989L;

	private Category category;
	private List<Tag> tags;

	public BaseArticle() {
		this(null);
	}
	
	public BaseArticle(Integer id) {
		super(id);
		this.category = new Category();
		this.tags = new ArrayList<Tag>();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
