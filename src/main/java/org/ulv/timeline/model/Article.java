package org.ulv.timeline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ulv.base.model.NamedEntity;

public class Article extends NamedEntity {

	private static final long serialVersionUID = -5712028049441065408L;

	private List<Tag> tags;
	private String link;
	private Category category;
	private Date onDate;

	public Article() {
		this(null);
	}
	
	public Article(Integer id) {
		super(id);
		this.category = new Category();
		this.tags = new ArrayList<Tag>();
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

}
