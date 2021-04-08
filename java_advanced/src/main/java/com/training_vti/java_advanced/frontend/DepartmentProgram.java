package com.training_vti.java_advanced.frontend;

import java.util.List;

import com.training_vti.java_advanced.backend.repository.testingsystem.DepartmentRepository;
import com.training_vti.java_advanced.entity.testingsystem.department.Department;

public class DepartmentProgram {
	public static void main(String[] args) {
		DepartmentRepository repo = new DepartmentRepository();
//
//		List<Department> departments = repo.getDepartmentAll();
//
//		for (Department department : departments) {
//			System.out.println(department.toString());
//		}
		
//		repo.createDepartment("Customer support", (short) 2, (short) 3);
//		repo.deleteDepartment((short)11);
	}
}
