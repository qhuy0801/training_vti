package com.vti.railway08_training.finalAssignment.backend.controller;

import com.vti.railway08_training.finalAssignment.backend.service.CandidateService;
import com.vti.railway08_training.finalAssignment.backend.service.ICandidateService;
import com.vti.railway08_training.finalAssignment.entity.Candidate;
import com.vti.railway08_training.finalAssignment.utils.CheckUtils;

public class CandidateController {
	private ICandidateService service;
	private CheckUtils check;

	public CandidateController() {
		service = new CandidateService();
		check = new CheckUtils();
	}

	public void createUsers(String firstName, String lastName, String phone, String email, String gradRank,
			String password) throws Exception {
		// Validation
		if (!check.isEmailValid(email)) {
			throw new Exception("The email is not valid, please try again!");
		}
		if (!check.isPasswordValid(password)) {
			check.passwordRequirement();
			throw new Exception("The email is not valid, please try again!");
		}
		// Passed validation, create candidate
		service.createUsers(firstName, lastName, phone, email, gradRank, password);
	}

	public void createUsers(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws Exception {
		// Validation
		if (!check.isEmailValid(email)) {
			throw new Exception("The email is not valid, please try again!");
		}
		if (!check.isPasswordValid(password)) {
			check.passwordRequirement();
			throw new Exception("The email is not valid, please try again!");
		}
		// Passed validation, create candidate
		service.createUsers(firstName, lastName, phone, email, expInYear, proSkill, password);
	}

	public boolean isEmailExists(String email) throws Exception {
		return service.isEmailExists(email);
	}

	public Candidate candidateLogin(String email, String password) throws Exception {
		// Validation
		if (!check.isEmailValid(email)) {
			throw new Exception("Your email is not valid, please check again!");
		}
		if (!isEmailExists(email)) {
			throw new Exception("This email is not exists on the system!");
		}
		return service.candidateLogin(email, password);
	}
}
