package com.training.backend.inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import com.training.entity.inheritance.Employee;
import com.training.entity.inheritance.Engineer;
import com.training.entity.inheritance.Officer;
import com.training.entity.inheritance.Worker;

public class EmployeesManagement {
	Scanner in = new Scanner(System.in);
	private ArrayList<Employee> employees = new ArrayList<>();
	
// ==========================================================================================
	public void sampleData() {
		System.out.println("Adding sample employees data...");
		employees.add(new Engineer("Employee 1 - Engineer", "Aerospace"));
		employees.add(new Officer("Employee 2 - Officer", "Front of house"));
		employees.add(new Worker("Employee 3 - Worker", (byte) 3));
		System.out.println("====== Done adding sample data ======");
	}

// ==========================================================================================
	public void addEmployee() {
		System.out.println("Please enter the name of the new employee: ");
		String name = in.nextLine();
		System.out.println("Please enter the position of the employee: ");
		System.out.println("1. Engineer / 2. Officer / 3.Worker");
		int selection = in.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Please insert the major:");
			in.nextLine();
			String major = in.nextLine();
			Engineer engineer = new Engineer(name, major);
			employees.add(engineer);
			break;
		case 2:
			System.out.println("Please insert the job: ");
			String job = in.nextLine();
			Officer officer = new Officer(name, job);
			employees.add(officer);
			break;
		case 3:
			System.out.println("Please insert the level: ");
			byte level = in.nextByte();
			Worker worker = new Worker(name, level);
			employees.add(worker);
			break;
		default:
			System.out.println("Wrong input, exit program...");
			return;
		}
	}

// ==========================================================================================
	public ArrayList<Employee> nameSearch(String s) {
		System.out.println("Exercuting name search tool...");

		// create initial values
		int match = 0;
		ArrayList<Employee> matchedEmployee = new ArrayList<Employee>();

		// search logic
		for (Employee employee : employees) {
			String fullName = employee.getName();
			if (fullName.toLowerCase().contains(s.toLowerCase())) {
				matchedEmployee.add(employee);
				match += 1;
			}
		}

		// print number of matches and return the matches
		System.out.printf("There is %d match(es)!\n", match);
		return matchedEmployee;
	}

// ==========================================================================================
	public void displayData() {
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}

// ==========================================================================================
	public ArrayList<Employee> deleteEmployee(String s) {
		System.out.println("Exercuting name deleting tool...");

		// execute name search for matches
		ArrayList<Employee> matchedEmployees = nameSearch(s);

		employees.removeAll(matchedEmployees);

		System.out.printf("After delete, there are %d employee(s) left!", employees.size());
		return employees;
	}

// ==========================================================================================
}
