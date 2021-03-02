package com.training.entity.polymorphism;

public class Student implements IStudent {
	private int ID;
	private String Name;
	private int Group;
	
//==========================================================================================
//	Constructor
public Student(int iD, String name, int group) {
		super();
		ID = iD;
		Name = name;
		Group = group;
	}
//==========================================================================================
//	Getters
public int getGroup() {
	return Group;
}

//==========================================================================================
//	Unimplemented methods
	@Override
	public void AttendaceCheck() {
		System.out.println(this.Name + " attendance check!");
	}

	@Override
	public void Study() {
		System.out.println(this.Name + " is studying.");
	}

	@Override
	public void CleanUp() {
		System.out.println(this.Name + " is cleaning.");
	}
}
