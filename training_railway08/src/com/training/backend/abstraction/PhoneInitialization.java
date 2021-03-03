package com.training.backend.abstraction;

import java.util.ArrayList;

import com.training.entity.abstraction.Contact;
import com.training.entity.abstraction.VietNamPhone;

public class PhoneInitialization {
	VietNamPhone data = new VietNamPhone();

//	//	Demo program
//	data.insertContact("Contact Demo 1", "567");
//	data.searchContact("Contact");
//	data.removeContact("contact 1");
//	data.updateContact("contact 2", "987");
//	data.print();

//==========================================================================================
	public void sampleData() {
		data.insertContact("Contact 1", "123");
		data.insertContact("Contact 2", "234");
		data.insertContact("Contact 3", "345");
		data.insertContact("Contact 4", "456");
	}

	public void insert() {
		data.insertContact("Contact Demo 1", "567");
	}

	public void search() {
		data.searchContact("Contact");
	}

	public void remove() {
		data.removeContact("contact 1");
	}

	public void update() {
		data.updateContact("contact 2", "987");
	}

	public void print() {
		data.print();
	}
}
