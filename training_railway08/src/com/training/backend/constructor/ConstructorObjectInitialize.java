package com.training.backend.constructor;

import java.util.Date;

import com.training.entity.constructor.Account;
import com.training.entity.constructor.Department;
import com.training.entity.constructor.Group;
import com.training.entity.constructor.Position;

public class ConstructorObjectInitialize {
//==========================================================================================
	public static void InitializeDepartment() {
//		Initialize objects (using constructors)

//		No parameter
		Department department1 = new Department();

//		Parameters: department name, default department id = 0
		Department department2 = new Department("Accounting");

		System.out.println(department1.getName());
		System.out.println(department2.getId() + " " + department2.getName());
	}

//==========================================================================================
	public static void InitializeAccount() {
//		Initialize objects (using constructors)

///		No parameter
		Account account1 = new Account();

//		Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName)
		Account account2 = new Account((short) 2, "account2@gmail.com", "reginageorge", "Regina", "George");

//		Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
		// create new position first
		Position position1 = new Position();
		position1.setName("Unidentified");
		// then create the object
		Account account3 = new Account((short) 3, "account3@gmail.com", "emmastone", "Emma", "Stone", position1);

//		Parameters: id, Email, User name, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
		Account account4 = new Account((short) 4, "account4@gmail.com", "stevetrevor", "Steve", "Trevor", position1,
				new Date("2019/12/12"));

//		check
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
		System.out.println(account4.toString());
	}

//==========================================================================================
	public static void InitializeGroup() {
//		Initialize objects (using constructors)

///		No parameter
		Group group1 = new Group();

//		Parameters: GroupName, Creator, array Account[] accounts, CreateDate
		// create new account for group creator
		Account account2 = new Account((short) 2, "account2@gmail.com", "reginageorge", "Regina", "George");
		// create object with this constructor
		Group group2 = new Group("Group 1", account2, new Account[] { account2 }, new Date(2020 / 12 / 12));

//		Parameters GroupName, Creator, array String[] user names , CreateDate
//		With each user namer entered, initialize new Account (with only user name, other data = null)
		Group group3 = new Group("Group 3", account2, new String[] { "emmastone", "stevetrevor" },
				new Date(2020 / 11 / 11));

//		check
		System.out.println(group1.toString());
		System.out.println(group2.toString());
		System.out.println(group3.toString());
	}

// ==========================================================================================
}
