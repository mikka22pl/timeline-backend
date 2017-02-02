package org.ulv.rssreader;

/*
 * Represents one rss message
 */
public class FeedMessage {

	private String title;
	private String descr;
	private String link;
	private String author;
	private String guid;

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

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeedMessage [title=");
		builder.append(title);
		builder.append(", descr=");
		builder.append(descr);
		builder.append(", link=");
		builder.append(link);
		builder.append(", author=");
		builder.append(author);
		builder.append(", guid=");
		builder.append(guid);
		builder.append("]");
		return builder.toString();
	}
}
