package com.training.entity.abstraction;

import java.util.ArrayList;

public class VietNamPhone extends Phone {
	
//==========================================================================================	
	@Override
	public void insertContact(String name, String phone) {
		contacts.add(new Contact(name, phone));
	}

	@Override
	public void removeContact(String name) {
		ArrayList<Contact> matched = new ArrayList<>(); // ArrayList can't remove element within a loop
		for (Contact contact : contacts) {
			if (contact.name.equalsIgnoreCase(name)) {
				matched.add(contact);
			}
		}
		contacts.removeAll(matched);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.name.equalsIgnoreCase(name)) { // match with exact name (case ignored)
				contact.number = newPhone;
			}
		}
	}

	@Override
	public void searchContact(String name) {
		int count = 0;
			for (Contact contact : contacts) {
				if (contact.name.contains(name)) { // match with name contains the searched line (case involved)
					count += 1;
					System.out.println(contact.name);
				}
			}
		System.out.println("There are total: " + count + " match(es)!");
	}

//==========================================================================================
//	Create print out
	public void print() {
		for (Contact contact : contacts) {
			System.out.println(contact.name + " " + contact.number);
		}
	}
}
