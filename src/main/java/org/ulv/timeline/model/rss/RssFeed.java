package org.ulv.timeline.model.rss;

import org.ulv.base.model.NamedEntity;

public class RssFeed extends NamedEntity {

	private static final long serialVersionUID = -316307361907154032L;

	private String url;
	private String category;

	public RssFeed() {
		this(null);
	}
	
	public RssFeed(Integer id) {
		super(id);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
