package org.ulv.timeline.model.rss;

import java.util.Date;
import java.util.List;

import org.ulv.timeline.model.BaseArticle;
import org.ulv.timeline.model.timeline.Timeline;

import com.google.common.collect.Lists;

public class RssEntry extends BaseArticle {

	private static final long serialVersionUID = -3846878865585493996L;

	private String link;
	private String title;
	private String descr;
	private String author;
	private String copyright;
	private String guid;
	private Date pubDate;
	private Date createdDate;
	private Boolean accepted;
	private Boolean rejected;
	private Date modyfiedDate;
	private Date feedDate;

	private final RssFeed rssFeed;
	private List<Timeline> timelines;
	private Integer limit;

	public RssEntry() {
		this(new RssFeed());
	}

	public RssEntry(RssFeed rssFeed) {
		this(null, rssFeed);
	}
	
	public RssEntry(Integer id) {
		this(id, null, new RssFeed());
	}

	public RssEntry(String title, RssFeed rssFeed) {
		this(null, title, rssFeed);
	}

	public RssEntry(Integer id, String title, RssFeed rssFeed) {
		super(id);
		this.rssFeed = rssFeed;
		this.title = title;
		this.timelines = Lists.newArrayList();
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

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Boolean getRejected() {
		return rejected;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

	public Date getModyfiedDate() {
		return modyfiedDate;
	}

	public void setModyfiedDate(Date modyfiedDate) {
		this.modyfiedDate = modyfiedDate;
	}

	public Date getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
	}

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
