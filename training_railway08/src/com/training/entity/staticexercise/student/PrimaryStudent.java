package com.training.entity.staticexercise.student;

public class PrimaryStudent extends Student {
	private static int count = 0;

	public PrimaryStudent(int id, String name) throws Exception {
		super(id, name);
		count++;
	}

	public static int getCount() {
		return count;
		// in the case that we don't define getCount for this, it still
		// got from Student and return count of all Students
	}
}
