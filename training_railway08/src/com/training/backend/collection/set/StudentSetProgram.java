package com.training.backend.collection.set;

import java.util.HashSet;
import java.util.Set;

import com.training.entity.collection.set.Student;

public class StudentSetProgram {
private Set<Student> students;

public StudentSetProgram() {
	students = new HashSet<>();	
}

public void sampleData() {
	students.add(new Student(1, "Student 1"));
	students.add(new Student(2, "Student 2"));
	students.add(new Student(3, "Student 4"));
	students.add(new Student(1, "Student 1"));
}

public int numberOfInstance() {
	return students.size();
}
}
