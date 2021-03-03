package com.training.backend.thissuperoverriding;

import com.training.entity.thissuperoverriding.Rectangle;
import com.training.entity.thissuperoverriding.Square;

public class RectangleSquare {
	public static void main(String[] args) {
		Square square = new Square();
		System.out.println(square.perimeter(0.2f));;
		System.out.println(square.area(0.2f));;
		
	}
}
