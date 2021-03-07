package com.training.frontend.generic;

import com.training.backend.generic.StudentGenericProgram;
import com.training.entity.generic.Student;

public class StudentGenericDemo {
public static void main(String[] args) {
	StudentGenericProgram program = new StudentGenericProgram();
	
	program.sampleData();
	program.printData();
	program.print(new Student<>(1.2f, "Student4 - float"));
	program.print(4.3265d);
}
}
