package com.training.entity.thissuperoverriding;

public class Square extends Rectangle {
		
		public float perimeter(float a) {
			return super.perimeter(a, a);			
		}
		
		public float area(float a) {
			return super.area(a, a);
	}
}
