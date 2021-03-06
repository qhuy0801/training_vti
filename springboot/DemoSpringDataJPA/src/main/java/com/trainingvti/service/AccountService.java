package com.trainingvti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trainingvti.entity.User;
import com.trainingvti.repository.IUserRepository;

@Service
public class AccountService implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Check user exists by username
		User user = repository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new org.springframework.security.core.userdetails.User(
				user.getUserName(), 
				user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole()));
	}

	@Override
	public User findByUserName(String username) {
		return repository.findByUserName(username);
	}

	public Page<User> getAllUsers(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
