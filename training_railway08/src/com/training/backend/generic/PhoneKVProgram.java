package com.training.backend.generic;

import java.util.ArrayList;
import java.util.List;

import com.training.entity.generic.PhoneKV;

public class PhoneKVProgram {
	List<PhoneKV> phones;

	public PhoneKVProgram() {
		phones = new ArrayList<>();
	}

	public void sampleData() {
		phones.add(new PhoneKV<Integer, Integer>(1, 123));
		phones.add(new PhoneKV<String, Integer>("User 1", 456));
		phones.add(new PhoneKV<String, Integer>("user2@gmail.com", 789));

	}

	public void printData() {
		for (PhoneKV phoneKV : phones) {
			System.out.println(phoneKV.getKey() + " " + phoneKV.getPhoneNumber() + "\n");
		}
	}
}
