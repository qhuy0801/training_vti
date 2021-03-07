package com.training.backend.finalexercise;

public class MyMath {
public static float min(float a, float b) {
	float min = a;
	if (b < a) {
		min = b;
	}
	return min;
}

public static float sum(float a, float b) {
	float sum = a + b;
	return sum;
}
}
