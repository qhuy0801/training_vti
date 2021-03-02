package com.training.backend.encapsulation;

import java.util.Scanner;

import com.training.entity.encapsulation.Student;

public class StudentManagement {
	Scanner in = new Scanner(System.in);
	private Student student;
	
//==========================================================================================
//	Create an object using constructor
	public void InitializeObject() {
		System.out.println("Enter full name: ");
		String name = in.nextLine();
		System.out.println("Enter home town: ");
		String home = in.nextLine();
		
		student = new Student(name, home);
	}
	
//==========================================================================================
//	Set GPA program
	public void SetGPAbackend() {
		System.out.println("Enter GPA: ");
		float GPA = in.nextFloat();
		student.setGPA(GPA);
	}
	
//==========================================================================================
//	Set GPA
	public void extraGPA() {
		System.out.println("Enter extra GPA: ");
		float extraGPA = in.nextFloat();
		if ((extraGPA + student.getGPA()) > 10 && (extraGPA + student.getGPA() <= 0)) {
			System.out.println("Extra GPA is invalid");
		} else {
			student.setGPA(student.getGPA() + extraGPA);
		}
	}
	
//==========================================================================================
//	Get data and check
	public void getData() {
		String graded = "";
		if (student.getGPA() < 4) {
			graded = "Weak";
		} else if (student.getGPA() >= 4  && student.getGPA() < 6) {
			graded = "Pass";
		} else if (student.getGPA() >= 6 && student.getGPA() < 8) {
			graded = "Good";
		} else {
			graded = "Excellent";
		}
		
		System.out.println(student.getGPA() + " - Graded: " + graded + " ");
	}
}

