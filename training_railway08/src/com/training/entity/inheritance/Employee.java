package com.training.entity.inheritance;

public abstract class Employee {
	private String fullName;
	private short age;
	private Gender gender;
	private String address;
	
//==========================================================================================	
//	Create constructors
	public Employee(String fullName) {
		this.fullName = fullName;
		System.out.println("Adding employee...");
	}
	
//==========================================================================================
//	Create getters, setters	
	public String getName() {
		return this.fullName;
	}
}
