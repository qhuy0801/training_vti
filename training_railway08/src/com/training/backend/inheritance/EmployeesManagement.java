package com.training.backend.inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import com.training.entity.inheritance.Employee;
import com.training.entity.inheritance.Engineer;
import com.training.entity.inheritance.Officer;
import com.training.entity.inheritance.Worker;

public class EmployeesManagement {
	Scanner in = new Scanner(System.in);

// ==========================================================================================
	public ArrayList<Employee> sampleData() {
		System.out.println("Adding sample employees data...");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Employee 1 - Normal empployee"));
		employees.add(new Engineer("Employee 2 - Engineer", "Aerospace"));
		employees.add(new Officer("Employee 3 - Officer", "Front of house"));
		employees.add(new Worker("Employee 4 - Worker", (byte) 3));
		System.out.println("====== Done adding sample data ======");
		return employees;
	}

// ==========================================================================================
	public void addEmployee(ArrayList<Employee> employees) {
		System.out.println("Please enter new employee full name: ");
		String s = in.nextLine();
		employees.add(new Employee(s));
	}

// ==========================================================================================
	public ArrayList<Employee> nameSearch(String s, ArrayList<Employee> employees) {
		System.out.println("Exercuting name search tool...");

		// create initial values
		int match = 0;
		ArrayList<Employee> matchedEmployee = new ArrayList<Employee>();

		// search logic
		for (Employee employee : employees) {
			String fullName = employee.getName();
			if (fullName.contains(s)) {
				matchedEmployee.add(employee);
				match += 1;
			}
		}

		// print number of matches and return the matches
		System.out.printf("There is %d match(es)!", match);
		return matchedEmployee;
	}

// ==========================================================================================
	public void displayData(ArrayList<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}

// ==========================================================================================
	public ArrayList<Employee> deleteEmployee(String s, ArrayList<Employee> employees) {
		System.out.println("Exercuting name deleting tool...");

		// execute name search for matches
		EmployeesManagement search = new EmployeesManagement();
		ArrayList<Employee> matchedEmployees = search.nameSearch(s, employees);

		employees.removeAll(matchedEmployees);

		System.out.printf("After delete, there are %d employee(s) left!", employees.size());
		return employees;
	}

// ==========================================================================================
}
