package com.vti.railway08_training.sampleFinalAssignment.backend.servives;

import java.util.List;

import com.vti.railway08_training.sampleFinalAssignment.backend.entities.User;
import com.vti.railway08_training.sampleFinalAssignment.backend.repository.IUserRepository;
import com.vti.railway08_training.sampleFinalAssignment.backend.repository.UserRepository;

public class UserServices implements IUserServices {
	private IUserRepository repository;

	public UserServices() {
		repository = new UserRepository();
	}

	public void createUsers(String fullName, String email, String password, String proSkill) throws Exception {
		repository.createUsers(fullName, email, password, proSkill);
	}

	public void createUsers(String fullName, String email, String password, int expInYear) throws Exception {
		repository.createUsers(fullName, email, password, expInYear);
	}

	public List<User> getUserList() throws Exception {
		return repository.getUserList();
	}

	public User searchID(int id) throws Exception {
		return repository.searchID(id);
	}

	public void deleteID(int id) throws Exception {
		repository.deleteID(id);
	}

	public boolean isEmailExists(String email) throws Exception {
		return repository.isEmailExists(email);
	}

	public boolean isAdmin(String email, String password) throws Exception {
		return repository.isAdmin(email, password);
	}
}
