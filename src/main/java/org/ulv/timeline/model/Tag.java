package org.ulv.timeline.model;

import org.ulv.base.model.NamedEntity;

public class Tag extends NamedEntity {

	private static final long serialVersionUID = -7715750352247366778L;
	private Language language;

	public Tag() {
		this(null);
	}
	
	public Tag(String name) {
		this(null, name);
	}

	public Tag(Integer id, String name) {
		super(id, name);
		this.language = new Language();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getId());
		builder.append(":");
		builder.append(super.getName());
		builder.append(", ");
		return builder.toString();
	}
}
