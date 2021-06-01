package com.trainingvti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingvti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short> {
	public Account findByUsername(String name);
}
