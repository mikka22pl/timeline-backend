package org.ulv.timeline.model;

import org.ulv.base.model.NamedEntity;

public class Tag extends NamedEntity {

	private static final long serialVersionUID = -7715750352247366778L;
	private Language language;

	public Tag() {
		this.language = new Language();
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
}
