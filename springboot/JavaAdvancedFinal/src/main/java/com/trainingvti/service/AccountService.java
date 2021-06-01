package com.trainingvti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trainingvti.entity.Account;
import com.trainingvti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService{

	@Autowired
	private IAccountRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Check user exists by username
		Account user = repository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword(),
				AuthorityUtils.createAuthorityList());
	}

	@Override
	public Account findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Page<Account> getAllAccounts(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
