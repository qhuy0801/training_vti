package com.vti.railway08_training.sampleFinalAssignment.backend.repository;

import java.util.List;

import com.vti.railway08_training.sampleFinalAssignment.backend.entities.User;

public interface IUserRepository {
	public void createUsers(String fullName, String email, String password, String proSkill) throws Exception;
	public void createUsers(String fullName, String email, String password, int expInYear) throws Exception;
	public List<User> getUserList() throws Exception;
	public User searchID(int id) throws Exception;
	public void deleteID(int id) throws Exception;
	public boolean isEmailExists(String email) throws Exception;
	public boolean isAdmin(String email, String password) throws Exception;
}
