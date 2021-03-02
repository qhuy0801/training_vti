package com.training.entity.inheritance;

public class Officer extends Employee {
	private String job;

//==========================================================================================	
//	Create constructors	
	public Officer(String fullName, String job) {
		super(fullName);
		this.job = job;
		System.out.println("Adding officer...");
	}
}