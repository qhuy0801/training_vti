package com.training.frontend.innerclass;

import com.training.entity.innerclass.Car;

public class CarDemo {
public static void main(String[] args) {
	Car car = new Car("Mazda", "8WD");
	
	Car.Engine engine = car.new Engine();
	engine.setEngineType("Crysler");
	
	System.out.println(engine.getEngineType());
}
}
