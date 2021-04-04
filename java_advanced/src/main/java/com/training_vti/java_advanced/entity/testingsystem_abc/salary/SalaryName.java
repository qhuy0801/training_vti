package com.training_vti.java_advanced.entity.testingsystem_abc.salary;

import java.util.stream.Stream;

public enum SalaryName {
	DEV(600), TEST(700), SCRUMMASTER(1500), PM(2000);
	
	private int salaryName;
	
	private SalaryName(int salaryName) {
		this.salaryName = salaryName;
	}

	public int getSalaryName() {
		return salaryName;
	}
	
	public static SalaryName of(int salaryName) {
		return  Stream.of(SalaryName.values())
				.filter(s -> s.getSalaryName() == salaryName)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
