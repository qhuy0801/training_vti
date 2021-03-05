package com.training.entity.exception;

import java.util.Scanner;

public class Account {	
// throw and exception exercise
	private int id;
	private String userName;
	private int age;
	
	public Account() {
		ScannerUtils in = new ScannerUtils();
		this.id = in.inputInt("ID must be a integer!");
		this.userName = in.inputString();
		this.age = in.inputAge();
	}
	
}
