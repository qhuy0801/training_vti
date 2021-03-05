package com.training.entity.staticexercise.geometry;

public class Round extends Geometry {
private float r;

	public Round(float r) {
	super();
	this.r = r;
}

	@Override
	public float Perimeter() {
		return (float) (r * 2 * Math.PI);
	}

	@Override
	public float Area() {
		return (float) (r * r * Math.PI);
	}

}
