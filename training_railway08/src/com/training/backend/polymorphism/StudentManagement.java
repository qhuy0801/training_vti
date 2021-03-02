package com.training.backend.polymorphism;

import java.util.Random;

import com.training.entity.polymorphism.Student;

public class StudentManagement {
	Random rand = new Random();
	
	//	Initialize object of class (private - encapsulation)
	private Student[] students;
	
	//	Initialize program (public - so that front end can access)
	public StudentManagement() {
		students = new Student[10];
	}
	
	public void SampleData() {
		for (int i = 0; i < students.length; i++) {
			students[i] = (new Student(i, ("Student " + i), rand.nextInt(3)+1));
		}
	}
	
	public void AllClassAttendaceCheck() {
		for (Student student : students) {
			student.AttendaceCheck();
		}
	}
	
	public void Group2Study() {
		for (Student student : students) {
			if (student.getGroup() == 1) {
				student.Study();
			}
		}
	}
	
	public void Group3CleanUp() {
		for (Student student : students) {
			if (student.getGroup() == 2) {
				student.CleanUp();
			}
		}
	}
}
