package com.training.entity.inheritance;

public class Worker extends Employee {
	private byte level;
	
//==========================================================================================	
//	Create constructors
	public Worker(String fullName, byte level) {
		super(fullName);
		this.level = level;
		System.out.println("Adding worker...");
	}
}