package com.training.entity.staticexercise.student;

public class Student {
	private int id;
	private String name;
	private static String school = "DHBK";
	private static int money = 0;
	private static int count = 0;
	
	public Student(int id, String name) {
		try {
			count++;
			if (count > 7) {
				throw new Exception("Maximum number of student reached, can't create this student!");
			}
			this.id = id;
			this.name = name;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getSchool() {
		return school;
	}

	public static void setSchool(String school) {
		Student.school = school;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + " " + school + "]";
	}

	public static int getMoney() {
		return money;
	}

	public static int useMoney(int moneyUsed) {
		return money -= moneyUsed;
	}
	
	public static void donateMoney() {
		Student.money += 100;
	}

	
	public static int getCount() {
		return count;
	}
}
