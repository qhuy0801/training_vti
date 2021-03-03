package com.training.frontend.abstraction;

import com.training.backend.abstraction.PhoneInitialization;

public class PhoneInitializationDemo {
public static void main(String[] args) {
	PhoneInitialization program = new PhoneInitialization();
	program.sampleData();
	//	Demo program
	program.insert();
	program.search();
	program.remove();
	program.update();
	program.print();
}
}
