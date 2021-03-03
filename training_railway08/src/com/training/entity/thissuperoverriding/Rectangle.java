package com.training.entity.thissuperoverriding;

public class Rectangle {
	
	public float perimeter(float width, float length) {
		System.out.println("Perimeter rectangle: ");
		return ((width + length) * 2);
	}
	
	public float area(float width, float length) {
		System.out.println("Area rectangle");
		return (width * length);
	}
}
