package com.training.entity.finalexercise;

public class Student {
	private final int id;
	private final String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public final void study() {
		System.out.println("Studying...");
	}
}
