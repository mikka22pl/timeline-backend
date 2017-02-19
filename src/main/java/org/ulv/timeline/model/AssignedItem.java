package org.ulv.timeline.model;

import java.io.Serializable;

public class AssignedItem implements Serializable {

	private static final long serialVersionUID = -3601034432591714792L;

	private Integer baseId;
	private Integer assigneeId;

	
	
	public AssignedItem() {}
	
	public AssignedItem(Integer baseId, Integer assigneeId) {
		this.baseId = baseId;
		this.assigneeId = assigneeId;
	}
	
	public Integer getBaseId() {
		return baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public Integer getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Integer assigneeId) {
		this.assigneeId = assigneeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssignedItem [baseId=");
		builder.append(baseId);
		builder.append(", assigneeId=");
		builder.append(assigneeId);
		builder.append("]");
		return builder.toString();
	}
}
