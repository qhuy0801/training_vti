package com.training.frontend.exception;

import com.training.backend.exception.Question4;

public class Question4Demo {
public static void main(String[] args) {
	Question4 program = new Question4();
	
	program.sampleData();
	
	try {
		program.getIndex(3);
	} catch (Exception e) {
		//	e.printStackTrace();
		System.out.println("Cannot find department");
	}
	
	System.out.println("Closing application...");
}
}
