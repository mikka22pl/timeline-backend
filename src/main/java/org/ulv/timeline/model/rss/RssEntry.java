package org.ulv.timeline.model.rss;

import java.util.Date;

public class RssEntry {

	private String link;
	private String title;
	private String descr;
	private String author;
	private String copyright;
	private String guid;
	private Date pubDate;
	private Date createdDate;
	private Boolean done;
	private Date doneDate;
	
	private final RssFeed rssFeed;

	public RssEntry() {
		this.rssFeed = new RssFeed();
	}
	
	public RssEntry(RssFeed rssFeed) {
		this(null, rssFeed);
	}

	public RssEntry(String title, RssFeed rssFeed) {
		this.rssFeed = rssFeed;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public RssFeed getRssFeed() {
		return rssFeed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
}
