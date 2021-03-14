package com.training.backend.collection.set;

import java.util.SortedSet;
import java.util.TreeSet;

import com.training.entity.collection.set.StudentNameUnique;

public class StudentSetNameSortedProgram {
	private SortedSet<StudentNameUnique> students;

	public StudentSetNameSortedProgram() {
		students = new TreeSet();
	}

	public void sampleData() {
		students.add(new StudentNameUnique(5, "Chi"));
		students.add(new StudentNameUnique(7, "Binh"));
		students.add(new StudentNameUnique(6, "Huy"));
		students.add(new StudentNameUnique(1, "Binh"));
		students.add(new StudentNameUnique(2, "Duong"));
		students.add(new StudentNameUnique(3, "An"));
		students.add(new StudentNameUnique(4, "Duong"));
	}

	public void print() {
		for (StudentNameUnique studentNameUnique : students) {
			System.out.println(studentNameUnique.toString());
		}
	}
}
