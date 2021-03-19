package com.vti.railway08_training.finalAssignment.frontend;

import java.util.Scanner;

import com.vti.railway08_training.finalAssignment.backend.controller.CandidateController;

public class CandidateResigter {
	private CandidateController controller = new CandidateController();
	Scanner in = new Scanner(System.in);

	public void FresherCandidateRegister() throws Exception {
		System.out.print("First name: ");
		String firstName = in.next();
		System.out.print("Last name: ");
		String lastName = in.next();
		System.out.print("Phone: ");
		String phone = in.next();
		System.out.print("Email: ");
		String email = in.next();
		System.out.print("Graduation rank: ");
		String gradRank = in.next();
		System.out.print("Password: ");
		String password = in.next();

		controller.createUsers(firstName, lastName, phone, email, gradRank, password);

		System.out.println("Registered fresher user successfully!");
	}

	public void ExpCandidateRegister() throws Exception {
		System.out.print("First name: ");
		String firstName = in.next();
		System.out.print("Last name: ");
		String lastName = in.next();
		System.out.print("Phone: ");
		String phone = in.next();
		System.out.print("Email: ");
		String email = in.next();
		System.out.print("Experienced year: ");
		int expInyear = in.nextInt();
		System.out.print("Pro skill: ");
		String proSkill = in.next();
		System.out.print("Password: ");
		String password = in.next();

		controller.createUsers(firstName, lastName, phone, email, expInyear, proSkill, password);

		System.out.println("Registered fresher user successfully!");
	}
}
