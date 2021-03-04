package com.training.frontend.inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import com.training.backend.inheritance.EmployeesManagement;
import com.training.entity.inheritance.Employee;

public class EmployeeManagementDemo {

//==========================================================================================
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// create a program pointer
		EmployeesManagement program = new EmployeesManagement();

		// create sample data
		program.sampleData();

		// program selection logic
		while (true) {
			System.out.println("Do you want to?: 1-Add employee / 2-Search / 3-Display data / 4-Delete");
			System.out.println("Or press any other key to exit program: ");
			int selection = in.nextInt();
			switch (selection) {
			case 1: {
				program.addEmployee();
				break;
			}
			case 2: {
				System.out.print("You choose to search! Please enter name here: ");
				in.nextLine(); // just to consume excess line
				String s = in.nextLine();
				program.nameSearch(s);
				break;
			}
			case 3: {
				program.displayData();
				break;
			}
			case 4: {
				System.out.println("You choose to delete! Please enter name here: ");
				in.nextLine();
				String s = in.nextLine();
				program.deleteEmployee(s);
				break;
			}
			default:
				System.out.println("Exiting...");
				return;
			}
		}
	}

//==========================================================================================
}
