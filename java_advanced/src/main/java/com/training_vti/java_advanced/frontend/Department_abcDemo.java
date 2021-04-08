package com.training_vti.java_advanced.frontend;

import java.util.List;

import com.training_vti.java_advanced.backend.repository.testingsystem_abc.DepartmentRepository;
import com.training_vti.java_advanced.entity.testingsystem_abc.Department;

public class Department_abcDemo {
public static void main(String[] args) {
	DepartmentRepository repository = new DepartmentRepository();
	
	List<Department> departments = repository.getDepartmentAll();
	
	for (Department deparment : departments) {
		System.out.println(deparment.toString());
	}
//	
//	System.out.println(repository.getDepartmentName("Marketing"));
	
//	System.out.println(repository.getDepartmentID((short) 9));
	
//	repository.createDepartment("CS");
	
//	repository.updateDepartmentName((short) 11, "DevOps");
	
//	repository.deleteDepartment((short) 11);
}
}
