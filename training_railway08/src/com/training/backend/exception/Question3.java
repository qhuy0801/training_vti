package com.training.backend.exception;

public class Question3 {
	public static void main(String[] args) {

		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bound");
		}
	}
}
