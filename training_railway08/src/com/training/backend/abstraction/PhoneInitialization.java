package com.training.backend.abstraction;

import java.util.ArrayList;

import com.training.entity.abstraction.Contact;
import com.training.entity.abstraction.VietNamPhone;

public class PhoneInitialization {
public static void main(String[] args) {
	
	//	Create a VietNamePhone object first to store data
	VietNamPhone data = new VietNamPhone();

	//	Call out program in this class to import sample data
	PhoneInitialization program = new PhoneInitialization();
	program.sampleData(data);
	
	//	Demo program
	data.insertContact("Contact Demo 1", "567");
	data.searchContact("Contact");
	data.removeContact("contact 1");
	data.updateContact("contact 2", "987");
	data.print();
}

//==========================================================================================
void sampleData(VietNamPhone data) {
	data.insertContact("Contact 1", "123");
	data.insertContact("Contact 2", "234");
	data.insertContact("Contact 3", "345");
	data.insertContact("Contact 4", "456");
}
}
