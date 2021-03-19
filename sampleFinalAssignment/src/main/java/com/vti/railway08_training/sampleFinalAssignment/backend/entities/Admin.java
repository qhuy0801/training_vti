package com.vti.railway08_training.sampleFinalAssignment.backend.entities;

public class Admin extends User {
	private int expInYear;

	public Admin(int id, String fullName, String email, int expInYear) {
		super(id, fullName, email);
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Admin [fullName=" + fullName + ", email=" + email + ", expInYear=" + expInYear + "]";
	}
}
