package com.trainingvti.backend.repository;

import java.util.List;

import com.trainingvti.entity.Account;

public interface IAccountRepository {
	public List<Account> getAccountAll();
	public void createAccount(String email, String username, String firstname, String lastname, short departmentID,
			short positionID, short salaryID);
	public Account getAccountID(short id);
	public void deleteAccount(short id);
}
