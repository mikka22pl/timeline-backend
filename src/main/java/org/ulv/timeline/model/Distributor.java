package org.ulv.timeline.model;

import org.ulv.base.model.NamedEntity;

public class Distributor extends NamedEntity {

	private static final long serialVersionUID = -4941594392565144607L;
	
	private Language language;
	
	public Distributor() {
		this.language = null;
	}

	public Language getLanguage() {
		if (language == null) {
			this.language = new Language();
		}
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
}
