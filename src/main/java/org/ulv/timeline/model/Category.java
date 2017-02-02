package org.ulv.timeline.model;

import org.ulv.base.model.NamedEntity;

public class Category extends NamedEntity {

	private static final long serialVersionUID = 7091928066571435679L;

	public Category() {
		this(null);
	}
	
	public Category(String name) {
		super(name);
	}
}
