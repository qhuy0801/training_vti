package com.trainingvti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingvti.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String name);
}
