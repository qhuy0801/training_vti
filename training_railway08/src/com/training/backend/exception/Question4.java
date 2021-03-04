package com.training.backend.exception;

import com.training.entity.exception.Department;

public class Question4 {
	Department[] departments = new Department[3];

	public void sampleData() {
		for (int i = 0; i < departments.length; i++) {
			departments[i] = new Department("Department" + i);
		}
	}
	
	public void getIndex(int index) {
		System.out.println(departments[index].getName());
	}
}
