package com.training.entity.annotations;

public class Student {
	private int id;
	private String name;
	private static int count = 0;

	public Student(String name) {
		super();
		count++;
		this.id = count;
		this.name = name;
	}

	/**
	 * 
	 * @deprecated {@link getIDv2()}
	 */
	public int getId() {
		return id;
	}
	
	public String getIDv2() {
		return "MSV: " + id;
	}

	public String getName() {
		return name;
	}

}
