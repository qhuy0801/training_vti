package com.training.frontend.encapsulation;

import com.training.backend.encapsulation.StudentManagement;
import com.training.entity.encapsulation.Student;

public class StudentManagementDemo {

//==========================================================================================
	public static void main(String[] args) {
		StudentManagement program = new StudentManagement();
		program.InitializeObject();
		program.SetGPAbackend();
		program.extraGPA();
		program.getData();
	}
}
