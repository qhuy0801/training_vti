package com.training.backend.staticexercsise;

import java.util.ArrayList;

import com.training.entity.staticexercise.student.PrimaryStudent;
import com.training.entity.staticexercise.student.SecondaryStudent;
import com.training.entity.staticexercise.student.Student;

public class StudentProgram {
	ArrayList<Student> students = new ArrayList<>();

	public void sampleData() {
		students.add(new Student(1, "Student A"));
		Student.donateMoney();

		students.add(new Student(2, "Student B"));
		Student.donateMoney();

		students.add(new Student(3, "Student C"));
		Student.donateMoney();
	}

	public void sampleData2() {
		students.add(new PrimaryStudent(4, "Primary student 1"));
		students.add(new PrimaryStudent(5, "Primary student 2"));
		students.add(new PrimaryStudent(6, "Primary student 3"));
		students.add(new PrimaryStudent(7, "Primary student 4"));
		students.add(new SecondaryStudent(8, "Secondary student 1"));
		students.add(new SecondaryStudent(9, "Secondary student 2"));
	}

	public void changeSchool() {
		Student.setSchool("DHCN");
	}

	public void printData() {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	public void useMoneyProgram() {
		System.out.println("Initial money: ");
		System.out.println(Student.getMoney());

		System.out.println("Student 1: - 50 for celebration");
		Student.useMoney(50);
		System.out.println(Student.getMoney());

		System.out.println("Student 2: - 20 for bread");
		Student.useMoney(20);
		System.out.println(Student.getMoney());

		System.out.println("Student 3: - 30 for study equippment");
		Student.useMoney(20);
		System.out.println(Student.getMoney());
	}

	public void studentCount() {
		System.out.println(Student.getCount());
	}

	public void studentCount2() {
		System.out.println(PrimaryStudent.getCount());
		System.out.println(SecondaryStudent.getCount());
	}
	
	public void sampleData3() {
		students.add(new PrimaryStudent(10, "Primary student 5"));
		students.add(new SecondaryStudent(11, "Secondary student 3"));
	}
}
