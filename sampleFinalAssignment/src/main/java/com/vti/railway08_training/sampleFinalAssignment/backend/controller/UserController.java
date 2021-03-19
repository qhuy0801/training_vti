package com.vti.railway08_training.sampleFinalAssignment.backend.controller;

import java.util.List;

import com.vti.railway08_training.finalAssignment.utils.CheckUtils;
import com.vti.railway08_training.sampleFinalAssignment.backend.entities.User;
import com.vti.railway08_training.sampleFinalAssignment.backend.servives.IUserServices;
import com.vti.railway08_training.sampleFinalAssignment.backend.servives.UserServices;

public class UserController {
	private IUserServices services;

	public UserController() {
		services = new UserServices();
	}

	public void createUsers(String fullName, String email, String password, String proSkill) throws Exception {
		if (!CheckUtils.isEmailValid(email)) {
			throw new Exception("Email is not valid, please check again");
		}
		if (!CheckUtils.isPasswordValid(password)) {
			throw new Exception("Password is not valid!");
		}
		services.createUsers(fullName, email, password, proSkill);
	}

	public void createUsers(String fullName, String email, String password, int expInYear) throws Exception {
		if (!CheckUtils.isEmailValid(email)) {
			throw new Exception("Email is not valid, please check again");
		}
		if (!CheckUtils.isPasswordValid(password)) {
			throw new Exception("Password is not valid!");
		}
		services.createUsers(fullName, email, password, expInYear);
	}
	
	public List<User> getUserList() throws Exception {
		return services.getUserList();
	}
	
	public User searchID(int id) throws Exception {
		return services.searchID(id);
	}
	
	public void deleteID(int id) throws Exception {
		services.deleteID(id);
	}
	
	public boolean isEmailExists(String email) throws Exception {
		return services.isEmailExists(email);
	}
	
	public boolean isAdmin(String email, String password) throws Exception {
		return services.isAdmin(email, password);
	}
}
