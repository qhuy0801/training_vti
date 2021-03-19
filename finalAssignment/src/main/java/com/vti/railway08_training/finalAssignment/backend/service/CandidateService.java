package com.vti.railway08_training.finalAssignment.backend.service;

import com.vti.railway08_training.finalAssignment.backend.repository.CandidateRepository;
import com.vti.railway08_training.finalAssignment.backend.repository.ICandidateRepository;
import com.vti.railway08_training.finalAssignment.entity.Candidate;

public class CandidateService implements ICandidateService{
	private ICandidateRepository repository;
	
	public CandidateService() {
		repository = new CandidateRepository();
	}
	
	public void createUsers(String firstName, String lastName, String phone, String email, String gradRank,
			String password) throws Exception {
		repository.createUsers(firstName, lastName, phone, email, gradRank, password);
	}
	
	public void createUsers(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws Exception {
		repository.createUsers(firstName, lastName, phone, email, expInYear, proSkill, password);
	}

	public boolean isEmailExists(String email) throws Exception {
		return repository.isEmailExists(email);
	}
	
	public Candidate candidateLogin(String email, String password) throws Exception {
		return repository.candidateLogin(email, password);
	}
}
