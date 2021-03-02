package com.training.entity.constructor;

import java.util.Date;

public class Account {
	private short id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public Date createDate;

//==========================================================================================
//	Create constructors
//	No parameter
	public Account() {
	}

//  Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName)
	public Account(short id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
	}

//	Parameter: user name
	public Account(String userName) {
		this.userName = userName;
	}
	
//	Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
	public Account(short id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = new Date();
	}

//	Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
	public Account(short id, String email, String userName, String firstName, String lastName, Position position,
			Date createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

//==========================================================================================
//	Create toString()
	@Override
	public String toString() {
		return id + " " + email + " " + userName + " " + fullName + " "
				+ (position != null ? position.getName() : "|Position is null|") + " " + createDate;
	}
}
