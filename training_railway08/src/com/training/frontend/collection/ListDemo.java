package com.training.frontend.collection;

import com.training.backend.collection.list.StudentProgram;

public class ListDemo {
public static void main(String[] args) {
	StudentProgram program = new StudentProgram();
	program.sampleData();
	
	System.out.println(program.numberOfInstance());
	
	program.selectInstance();
	
	program.addInstance();
	
	program.searchID();
	
	program.searchName();
	
	program.deleteMatchedName();
	
	program.deleteNameOfID();
	
	program.deleteID();

}
}
