package com.training.entity.encapsulation;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private float GPA;
//==========================================================================================	
//	Create constructors
	public Student(String name, String homeTown) {
		this.name = name;
		this.homeTown = homeTown;
		this.GPA = 0f;
	}
//==========================================================================================
//	Create getters, setters
	public void setGPA(float GPA) {
		if (0 <= GPA && 10 >= GPA) {
			this.GPA = GPA;
		} else {
			System.out.println("GPA is invalid");
			return;
		}
	}
		
	public float getGPA() {
		return GPA;
	}
	
//==========================================================================================
//	Create toString()
	@Override
	public String toString() {
		return (this.id == 0 ? "ID is null - " : (this.id + " ")) + this.name + " " + this.GPA;
	}
}
