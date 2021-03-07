package com.training.backend.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.training.entity.collection.list.Student;

public class StudentProgram {
	Scanner in = new Scanner(System.in);
	List<Student> students;

	public StudentProgram() {
		students = new ArrayList<>();
	}

	// sample data
	public void sampleData() {
		students.add(new Student("Student 1"));
		students.add(new Student("Student 2"));
		students.add(new Student("Student 3"));
	}

	// print out the number of instances
	public int numberOfInstance() {
		return students.size();
	}

	public void selectInstance() {
		System.out.println("Select the instance position that you want to select: ");
		int i = in.nextInt();
		System.out.println(students.get(i-1).getId() + " " + students.get(i-1).getName());
	}

	public void addInstance() {
		// add to the first position
		students.add(0, new Student("Student add 1"));
		// add to last position
		students.add(new Student("Student add 2"));
		students.add(new Student("Student add 2"));
	}

	public void reverseData() {
		Collections.reverse(students);
	}

	public void searchID() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the ID to search: ");
		int id = in.nextInt();
		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println(student.getId() + " " + student.getName());
			}
		}
	}

	public void searchName() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name to search: ");
		String name = in.nextLine();
		int matched = 0;
		for (Student student : students) {
			if (student.getName().toLowerCase().contains(name.toLowerCase())) {
				matched++;
				System.out.println(student.getId() + " " + student.getName());
			}
		}
		System.out.println("Number of matched result: " + matched);
	}

	public void deleteMatchedName() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i+1; j < students.size(); j++) {
				if (students.get(i).getName().equalsIgnoreCase(students.get(j).getName())) {
					students.remove(j);
				}
			}
		}
	}

	public void deleteNameOfID() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the ID to search and delete: ");
		int id = in.nextInt();
		for (Student student : students) {
			if (student.getId() == id) {
				student.setName(null);
			}
		}
	}

	public void deleteID() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the ID to search and delete: ");
		int id = in.nextInt();
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(student);
			}
		}
	}

	// create new array list
	List<Student> studentCopy = new ArrayList<>();
	public void copyStudents() {
		studentCopy.addAll(students);
	}
}
