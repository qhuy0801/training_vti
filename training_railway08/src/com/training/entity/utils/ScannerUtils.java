package com.training.entity.utils;

import java.util.Scanner;

public class ScannerUtils {
	static Scanner in = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			System.out.println("Input the number: ");
			try {
				String iTemp = in.nextLine();
				int i = Integer.parseInt(iTemp);
				return i;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}

	public static float inputFloat() {
		while (true) {
			System.out.println("Please input float: ");
			try {
				String iTemp = in.nextLine();
				float i = Float.parseFloat(iTemp);
				return i;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}

	public static String inputString() {
		System.out.print("Please input string: ");
		in.nextLine(); // to consumer excess line
		String s = in.nextLine();
		return s;
	}
// add ins
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
