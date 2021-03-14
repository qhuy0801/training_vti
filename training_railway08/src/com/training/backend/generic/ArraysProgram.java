package com.training.backend.generic;

public class ArraysProgram {
	public <T> void print(T[] a) {
		for (T t : a) {
			System.out.print(t+ ", ");
		}
		System.out.println();
	}
}