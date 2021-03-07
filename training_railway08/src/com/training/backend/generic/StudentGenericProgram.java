package com.training.backend.generic;

import java.util.ArrayList;
import java.util.List;

import com.training.entity.generic.Student;

public class StudentGenericProgram {
	List<Student> students;

	public StudentGenericProgram() {
		students = new ArrayList<>();
	}

	public void sampleData() {
		students.add(new Student<Integer>(1, "Student 1 - int"));
		students.add(new Student<Float>(2.2f, "Student 2 - float"));
		students.add(new Student<Double>(-168.2d, "Student 3 - double"));
	}

	public void printData() {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	
	public <T> void print(T t) {
		System.out.println(t); // load student will to string student, load number will print number
	}
}
