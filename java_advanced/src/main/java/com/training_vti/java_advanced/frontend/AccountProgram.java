package com.training_vti.java_advanced.frontend;

import java.util.List;

import com.training_vti.java_advanced.backend.repository.testingsystem.AccountRepository;
import com.training_vti.java_advanced.entity.testingsystem.Account;

public class AccountProgram {
public static void main(String[] args) {
	AccountRepository repo = new AccountRepository();
	
	List<Account> accounts = repo.getAccountAll();
	
	for (Account account : accounts) {
		System.out.println(account.toString());
	}
	
//	repo.createAccount("test1@gmail", "test1", "firstname", "lastname", (short) 6,(short) 2,(short) 2);
}
}
