package com.training.frontend.collection;

import com.training.backend.collection.set.StudentSetNameUniqueProgram;

public class StudentNameUniqueDemo {
	public static void main(String[] args) {
		StudentSetNameUniqueProgram program = new StudentSetNameUniqueProgram();

		program.sampleData();
		System.out.println(program.numberOfInstance());
	}
}
