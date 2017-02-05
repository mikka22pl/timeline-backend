package org.ulv.timeline.model;

import java.util.Date;

public class Article extends BaseArticle {

	private static final long serialVersionUID = -5712028049441065408L;

	private String link;
	private Date onDate;

	public Article() {
		this(null);
	}
	
	public Article(Integer id) {
		super(id);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

}
