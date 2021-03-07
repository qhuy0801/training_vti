package com.training.entity.collection.list;

public class Student {
	private static int count = 0;
	private int id;
	private String name;

	// constructor
	public Student(String name) {
		count++;
		this.id = count;
		this.name = name;
	}

	// getters and setters
	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
