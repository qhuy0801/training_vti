package com.training.backend.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentMapProgram {
	Scanner in = new Scanner(System.in);
	Map<Integer, String> students;

	public StudentMapProgram() {
		students = new HashMap<>();
	}

	public void sampleData() {
		students.put(1, "Student 1");
		students.put(2, "Student 2");
		students.put(3, "Student 3");
	}

	public void printKey() {
		System.out.println(students.keySet());
	}

	public void printValue() {
		System.out.println("Please enter the key to search: ");
		Integer i = in.nextInt();
		System.out.println(students.get(i));
	}
	
	public void convertToSet() {
		Set<Map.Entry<Integer, String>> set = students.entrySet();
	}
}
