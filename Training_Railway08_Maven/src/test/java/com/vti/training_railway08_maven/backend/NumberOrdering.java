package com.vti.training_railway08_maven.backend;

public class NumberOrdering {
	public static void main(String[] args) {
		int[] numbers = { 10, 20, 90, 50, 100, 60, 30, 80, 70, 40 };
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = (i + 1); j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = temp;
				}

			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
