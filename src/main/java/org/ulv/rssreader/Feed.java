package org.ulv.rssreader;

import java.util.ArrayList;
import java.util.List;

/*
 * Stores an rss feed
 */
public class Feed {

	private final String title;
	private final String link;
	private final String descr;
	private final String language;
	private final String copyright;
	private final String pubDate;
	
	private final List<FeedMessage> entries = new ArrayList<FeedMessage>();
	
	public Feed(String title, String link, String descr, String language, String copyright, String date) {
		this.title = title;
		this.link = link;
		this.descr = descr;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = date;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescr() {
		return descr;
	}

	public String getLanguage() {
		return language;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public List<FeedMessage> getEntries() {
		return entries;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feed [title=");
		builder.append(title);
		builder.append(", link=");
		builder.append(link);
		builder.append(", descr=");
		builder.append(descr);
		builder.append(", language=");
		builder.append(language);
		builder.append(", copyright=");
		builder.append(copyright);
		builder.append(", pubDate=");
		builder.append(pubDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
