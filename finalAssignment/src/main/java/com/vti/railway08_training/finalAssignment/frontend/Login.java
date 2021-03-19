package com.vti.railway08_training.finalAssignment.frontend;

import java.util.Scanner;

import com.vti.railway08_training.finalAssignment.backend.controller.CandidateController;
import com.vti.railway08_training.finalAssignment.entity.FresherCandidate;
import com.vti.railway08_training.finalAssignment.utils.CheckUtils;

public class Login {
	private CandidateController controller;
	Scanner in = new Scanner(System.in);
	CheckUtils check = new CheckUtils();
	
	public Login() {
		controller = new CandidateController();
	}
	
	public void isLoggedIn(String email, String password) throws Exception {
		if (controller.candidateLogin(email, password) instanceof FresherCandidate) {
			FresherCandidateMenu();
		} else {
			ExperiencedCandidateMenu();
		}
		return;
	}

	void FresherCandidateMenu() {
		System.out.println("This is fresher candidate menu");
		System.out.println("==============================");
	}
	
	void ExperiencedCandidateMenu() {
		System.out.println("This is experienced candidate menu");
		System.out.println("==================================");
	}
}
