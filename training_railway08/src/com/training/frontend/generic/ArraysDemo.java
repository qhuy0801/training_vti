package com.training.frontend.generic;

import com.training.backend.generic.ArraysProgram;

public class ArraysDemo {
	public static void main(String[] args) {
		
		Integer[] a = { 1, 2, 3 };
		Float[] b = { 4.3f, 5.6f, 7.2f };
		Double[] c = { -126.6d, 365.3d, 94532.2d };
		
		ArraysProgram program = new ArraysProgram();
		program.print(a);
		program.print(b);
		program.print(c);
	}
}
