package com.training.frontend.finalexercise;

import com.training.backend.finalexercise.MyMath;

public class MyMathDemo {
	public static void main(String[] args) {
		System.out.println(Math.max(5, 7));
		
		System.out.println(MyMath.min(-3.5f, 2));
		System.out.println(MyMath.sum(3.3f, 3.4f));
		// static method doesn't need to create object like: MyMath program = new MyMath();
		
	}
}
