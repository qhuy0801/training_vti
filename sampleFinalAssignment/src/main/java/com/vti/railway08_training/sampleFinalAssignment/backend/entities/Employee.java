package com.vti.railway08_training.sampleFinalAssignment.backend.entities;

public class Employee extends User {

	private String proSkill;

	public Employee(int id, String fullName, String email, String proSkill) {
		super(id, fullName, email);
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", email=" + email + ", proSkill=" + proSkill + "]";
	}

}
