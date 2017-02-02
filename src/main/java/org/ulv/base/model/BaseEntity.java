package org.ulv.base.model;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6354027782992894861L;

	protected Integer id;
	
	private Date createdDate;
	
	private Date modifiedDate;

	public BaseEntity() {
		this(null);
	}

	public BaseEntity(Integer id) { this.id = id; }
	
	public Integer getId() { return id; }

	public void setId(Integer id) {
		if (id == null || id == 0) {
			id = null;
		}
		this.id = id; 
	}

	public boolean isNew() { return id == null; }
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String toString()
	{
		return "#[" + id + "] ";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
