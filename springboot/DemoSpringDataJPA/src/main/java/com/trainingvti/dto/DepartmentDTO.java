package com.trainingvti.dto;

public class DepartmentDTO {
	private short id;
	private String name;
	private Short address;
	private Short emulationPoint;
	
	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(short id, String name, Short address, Short emulationPoint) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emulationPoint = emulationPoint;
	}
	
	
	
	public void setId(short id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Short address) {
		this.address = address;
	}

	public void setEmulationPoint(Short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Short getAddress() {
		return address;
	}
	
	public Short getEmulationPoint() {
		return emulationPoint;
	}
}
