package com.training.frontend.collection;

import com.training.backend.collection.set.StudentSetProgram;

public class StudentDemo {
	public static void main(String[] args) {
		StudentSetProgram program = new StudentSetProgram();
		
		program.sampleData();
		System.out.println(program.numberOfInstance());
	}

}
