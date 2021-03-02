package com.training.entity.constructor;

public class Department {
	private short id;
	private String name;
	
//==========================================================================================
//	Create constructors
//	No parameter
	public Department() {
	}

//	Parameter: department name, default department id = 0
	public Department(String name) {
		this.id = 0;
		this.name = name;
	}

//==========================================================================================
//	Create getters
	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
