package com.training.entity.generic;

import java.util.Arrays;

public class EmployeeT<T> {
	private int id;
	private String name;
	private T[] salaries;
	
	public EmployeeT(int id, String name, T[] salaries) {
		super();
		this.id = id;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "EmployeeT [id=" + id + ", name=" + name + ", salaries=" + Arrays.toString(salaries) + "]";
	}
	
	public T lastSalary() {
		return this.salaries[salaries.length-1];
	}
}
