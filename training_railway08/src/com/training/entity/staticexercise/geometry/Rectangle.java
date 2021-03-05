package com.training.entity.staticexercise.geometry;

public class Rectangle extends Geometry{
	private float width;
	private float height;
	
	public Rectangle(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public float Perimeter() {
		return ((width + height) * 2);
	}

	@Override
	public float Area() {
		return (width * height);
	}
	

}
