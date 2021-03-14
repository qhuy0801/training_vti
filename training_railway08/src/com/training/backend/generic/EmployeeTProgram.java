package com.training.backend.generic;

import java.util.ArrayList;
import java.util.List;

import com.training.entity.generic.EmployeeT;

public class EmployeeTProgram {
	List<EmployeeT> employees;

	public EmployeeTProgram() {
		employees = new ArrayList<>();
	}

	public void data() {
		employees.add(new EmployeeT<Float>(1, "Employee - 1", new Float[] { 12.4f, 15.6f, 17.2f }));
		employees.add(new EmployeeT<Double>(2, "Employee  - 2", new Double[] { 10.3d, 11.2d, 12.3d }));
		employees.add(new EmployeeT<Integer>(3, "Employee - 3", new Integer[] { 13, 14, 15 }));
	}
	
	public void printLastSalaryProgram() {
		for (EmployeeT employeeT : employees) {
			System.out.println(employeeT.lastSalary());;
		}
	}
}
