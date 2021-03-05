package com.training.entity.staticexercise.geometry;

public abstract class Geometry implements GeometryInterface {
	private static int maximumCount = 5;
	private static int count = 0;

public Geometry() {
	try {
		count++;
		if (count > maximumCount) {
			throw new Exception("Maximum geometry object reach, can't create this object!");
		}
		System.out.println("Object created!");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}
