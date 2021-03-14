package com.training.backend.collection.set;

import java.util.HashSet;
import java.util.Set;

import com.training.entity.collection.set.StudentNameUnique;

public class StudentSetNameUniqueProgram {
	private Set<StudentNameUnique> students;

	public StudentSetNameUniqueProgram() {
		students = new HashSet();
	}

	public void sampleData() {
		students.add(new StudentNameUnique(1, "Student 1"));
		students.add(new StudentNameUnique(2, "Student 2"));
		students.add(new StudentNameUnique(3, "Student 4"));
		students.add(new StudentNameUnique(4, "Student 1"));
	}

	public int numberOfInstance() {
		return students.size();
	}
}
