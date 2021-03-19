package com.vti.railway08_training.finalAssignment.entity;

public abstract class Candidate {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;

	public Candidate(String firstName, String lastName, String phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
}
