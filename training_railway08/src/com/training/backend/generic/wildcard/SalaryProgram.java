package com.training.backend.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

import com.training.entity.generic.wildcard.Salary;

public class SalaryProgram {
	List<Salary> salaries;

	public SalaryProgram() {
		salaries = new ArrayList<>();
	}

	public void sampleData() {
		salaries.add(new Salary(23000)); // this okay >int
		salaries.add(new Salary<Float>(2345.6f)); // this okay
		salaries.add(new Salary((double) 2345.7d)); // this also okay
	}

	public void printData() {
		for (Salary salary : salaries) {
			System.out.println(salary.getSalary());
		}
	}
}
