package com.training.entity.constructor;

import java.util.Date;

public class Group {
	private short id;
	private String name;
	private Account creator;
	private Date createDate;
	private Account[] members;
	
//==========================================================================================
//	Create constructors
//	No parameter
	public Group() {
	}

//	Parameters: GroupName, Creator, array Account[] accounts, CreateDate
	public Group(String name, Account creator, Account[] members, Date createDate) {
		this.name = name;
		this.creator = creator;
		this.members = members;
		this.createDate = createDate;
	}

//	Parameters: GroupName, Creator, array String[] user names , CreateDate
//	With each user namer entered, initialize new Account (with only user name, other data = null)
	public Group(String name, Account creator, String[] userNames, Date createDate) {
		this.name = name;
		this.creator = creator;

		members = new Account[userNames.length];
		for (int i = 0; i < members.length; i++) {
			members[i] = new Account(userNames[i]);
		}

		this.createDate = createDate;
	}

//==========================================================================================
//	Create toString()
	@Override
	public String toString() {
		String s = "";
		String s1= "";
		if (members == null) {
			s1 = "This group is empty";
		} else {
			for (Account account : members) {
				s1 += account.userName + " ";
		}
		}
		s = "Group ID: " + id + " Members: " + s1 ;
		return s;
	}
}
