package org.ulv.timeline.model.rss;

import org.ulv.base.model.NamedEntity;
import org.ulv.timeline.model.Distributor;

public class RssFeed extends NamedEntity {

	private static final long serialVersionUID = -316307361907154032L;

	private String url;
	private String category;
	private Distributor distributor;
	
	// number of draft entries
	private int draftCount;
	
	// number of accepted entries
	private int acceptedCount;
	
	// number of loaded new entries
	private int loadedCount;

	public RssFeed() {
		this(null);
	}
	
	public RssFeed(Integer id) {
		super(id);
		this.distributor = new Distributor();
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDraftCount() {
		return draftCount;
	}

	public void setDraftCount(int draftCount) {
		this.draftCount = draftCount;
	}

	public int getAcceptedCount() {
		return acceptedCount;
	}

	public void setAcceptedCount(int acceptedCount) {
		this.acceptedCount = acceptedCount;
	}

	public int getLoadedCount() {
		return loadedCount;
	}

	public void setLoadedCount(int loadedCount) {
		this.loadedCount = loadedCount;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
}
