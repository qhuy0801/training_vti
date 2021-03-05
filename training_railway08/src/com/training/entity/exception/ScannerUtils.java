package com.training.entity.exception;

import java.util.Scanner;

public class ScannerUtils {
	static Scanner in = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			System.out.println("Input the number: ");
			int i;
			try {
				String iTemp = in.nextLine();
				i = Integer.parseInt(iTemp);
				return i;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			System.out.println("Please input float: ");
			float i;
			try {
				String iTemp = in.nextLine();
				i = Float.parseFloat(iTemp);
				return i;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static String inputString() {
		System.out.println("Please input string");
		String s = in.nextLine();
		return s;
	}

	public static int inputAge() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Input the age: ");
			int i;
			try {
				String iTemp = in.nextLine();
				i = Integer.parseInt(iTemp);
				if (i <= 0) {
					throw new InvalidAgeInputingException("Age must be greater than 0");
				}
				return i;
			} catch (InvalidAgeInputingException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static int inputAccountAge() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Input the age: ");
			int i;
			try {
				String iTemp = in.nextLine();
				i = Integer.parseInt(iTemp);
				if (i < 18) {
					throw new InvalidAgeInputingException("Age must be greater than 18");
				}
				return i;
			} catch (InvalidAgeInputingException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
