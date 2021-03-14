package com.training.backend.annotations;

import com.training.entity.annotations.Student;

public class StudentProgram {
	private Student student;

	public StudentProgram() {
		student = new Student("Student 1");
	}

	public void print() {
		System.out.println(student.getId());
		System.out.println(student.getIDv2());
	}

}
