package com.training.frontend.generic;

import com.training.backend.generic.PrintT;
import com.training.entity.generic.StudentT;


public class PrintTDemo {
public static void main(String[] args) {
	PrintT program = new PrintT();
	
	program.printT(1);
	program.printT(1f);
	
	program.printT(new StudentT(-3002.0463d, "Student - double"));
}
}
