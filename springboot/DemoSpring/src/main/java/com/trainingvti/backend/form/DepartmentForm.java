package com.trainingvti.backend.form;

public class DepartmentForm {
	private short id;
	private String name;
	private Short address;
	private Short emulationPoint;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getAddress() {
		return address;
	}

	public void setAddress(Short address) {
		this.address = address;
	}

	public Short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(Short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	public DepartmentForm() {
		super();
	}

}
