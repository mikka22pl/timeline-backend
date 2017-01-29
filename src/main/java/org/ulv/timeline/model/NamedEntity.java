package org.ulv.timeline.model;


public class NamedEntity extends BaseEntity
{
	private static final long serialVersionUID = 5952341805619253945L;
	
	private String name;
	private String descr;
	
	public NamedEntity() {
		this(null, null);
	}
	
	public NamedEntity(Integer id) {
		this(id, null);
	}
	
	public NamedEntity(String name) {
		this(null, name);
	}
	
	public NamedEntity(Integer id, String name) {
		this(id, name, null);
	}
	
	public NamedEntity(Integer id, String name, String descr) {
		super(id);
		this.name = name;
		this.descr = descr;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID #");
		builder.append(super.getId());
		builder.append(" :: [name=");
		builder.append(name);
		builder.append("] <<-- ");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamedEntity other = (NamedEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}