package com.trainingvti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.trainingvti.entity.Account;

public interface IAccountService extends UserDetailsService{
	public Account findByUsername(String username);

	Page<Account> getAllAccounts(Pageable pageable);
}
