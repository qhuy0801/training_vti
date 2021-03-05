package com.training.backend.exception;

import java.util.Scanner;

public class Question5 {
	Scanner in = new Scanner(System.in);

	public int inputAge() {
		while (true) {
			System.out.println("Input the number: ");
			int age;
			try {
				String ageTemp = in.nextLine();
				age = Integer.parseInt(ageTemp);
				if (age < 0) {
					throw new IllegalArgumentException("Age must >0");
				}
				return age;
			} catch (NumberFormatException e) {
				System.out.println("Wrong inputing! Please input an age as int, input again.");
			} catch (IllegalArgumentException e) {
				System.out.println("Wrong inputing! Please input an age as int, input again (age > 0).");
			}
		}
	}
}
