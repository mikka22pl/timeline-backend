package org.ulv.timeline.model.builders;

import org.ulv.timeline.model.Category;
import org.ulv.timeline.model.Tag;
import org.ulv.timeline.model.rss.RssEntry;

public class RssEntryBuilder {

	private RssEntry instance;
	
	public RssEntryBuilder() {
		this.instance = new RssEntry();
	}
	
	public RssEntryBuilder withId(Integer id) {
		instance.setId(id);
		return this;
	}
	
	public RssEntryBuilder withTitle(String title) {
		instance.setTitle(title);
		return this;
	}
	
	public RssEntryBuilder withLink(String link) {
		instance.setLink(link);
		return this;
	}
	
	public RssEntryBuilder withCategory(Category category) {
		instance.setCategory(category);
		return this;
	}
	
	public RssEntryBuilder withTag(Tag tag) {
		instance.getTags().add(tag);
		return this;
	}
	
	public RssEntry build() {
		return instance;
	}
}
