package com.training.entity.inheritance;

public class Engineer extends Employee {
	private String major;
	
//==========================================================================================	
//	Create constructors	
	public Engineer(String fullName, String major) {
		super(fullName);
		this.major = major;
		System.out.println("Adding engineer...");
	}
}