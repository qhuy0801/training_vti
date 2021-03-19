package com.vti.railway08_training.sampleFinalAssignment.backend.entities;

public abstract class User {
	protected int id;
	protected String fullName;
	protected String email;
	private String password;
	
	// Constructor write to database
	public User(int id, String fullName, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean checkPassword(String password) {
		if (password.equals(this.password));
		return true;
	}
}
