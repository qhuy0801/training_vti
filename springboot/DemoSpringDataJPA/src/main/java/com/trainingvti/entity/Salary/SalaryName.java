package com.trainingvti.entity.Salary;

public enum SalaryName {
	DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");
	
	private String value;
	
	private SalaryName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
