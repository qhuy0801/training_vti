package com.training.frontend.exception;

import com.training.entity.exception.ScannerUtils;

public class ScannerUtilsDemo {
public static void main(String[] args) {
	// test ScannerUtils
	ScannerUtils program = new ScannerUtils();
	System.out.println(program.inputInt("Wrong int format"));	
	System.out.println(program.inputFloat("Wrong float fomat"));
}
}
