package com.training.entity.generic;

import java.util.ArrayList;
import java.util.List;

public class StudentTProgram {
	List<StudentT> students;

	public StudentTProgram() {
		students = new ArrayList<>();
	}

	public void sampleData() {
		students.add(new StudentT<Integer>(1, "Student 1 - int"));
		students.add(new StudentT<Float>(2.2f, "Student 2 - float"));
		students.add(new StudentT<Double>(-168.2d, "Student 3 - double"));
	}

	public void printData() {
		for (StudentT student : students) {
			System.out.println(student.toString());
		}
	}
}
