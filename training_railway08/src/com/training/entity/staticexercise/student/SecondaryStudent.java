package com.training.entity.staticexercise.student;

public class SecondaryStudent extends Student{
	private static int count = 0;

	public SecondaryStudent(int id, String name) {
		super(id, name);
		count++;
	}

	public static int getCount() {
		return count;
	}
}
