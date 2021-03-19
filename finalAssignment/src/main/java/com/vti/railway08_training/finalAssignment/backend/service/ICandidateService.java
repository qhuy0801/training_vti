package com.vti.railway08_training.finalAssignment.backend.service;

import com.vti.railway08_training.finalAssignment.entity.Candidate;

public interface ICandidateService {
	public void createUsers(String firstName, String lastName, String phone, String email, String gradRank,
			String password) throws Exception;
	public void createUsers(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws Exception;
	public boolean isEmailExists(String email) throws Exception;
	public Candidate candidateLogin(String email, String password) throws Exception;
}
