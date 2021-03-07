package com.training.entity.generic.wildcard;

public class Salary<T extends Number> {
	private T salary;

	public Salary(T salary) {
		super();
		this.salary = salary;
	}

	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}
	
}
