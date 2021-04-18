package com.trainingvti.dto;

public class DepartmentFilter {
	private Short minID;
	private Short maxID;
	
	public DepartmentFilter() {
		super();
	}

	public Short getMinID() {
		return minID;
	}

	public void setMinID(Short minID) {
		this.minID = minID;
	}

	public Short getMaxID() {
		return maxID;
	}

	public void setMaxID(Short maxID) {
		this.maxID = maxID;
	}
	 
}
