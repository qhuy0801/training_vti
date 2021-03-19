package com.vti.railway08_training.finalAssignment.frontend;

import java.util.Scanner;

public class ProgramDemo {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Do you want to login or register new candidate? 1 - login / 2 - register / 3 - quit");
			int selection = in.nextInt();
			switch (selection) {
			case 1:
				System.out.print("Please enter the email: ");
				String email = in.next();
				System.out.print("Please enter the password: ");
				String password = in.next();
				Login login = new Login();
				login.isLoggedIn(email, password);
				break;
			case 2:
				System.out.println("What do you want to register: 1 - frehser candidate / 2 - experienced candidate");
				CandidateResigter register = new CandidateResigter();
				int selection1 = in.nextInt();
				if (selection1 == 1) {
					register.FresherCandidateRegister();
				}
				if (selection1 == 2) {
					register.ExpCandidateRegister();
				}
				break;
			case 3:
				System.out.println("Quitting...");
				return;
			default:
				System.out.println("Wrong choice, please select again!");
				break;
			}
		}
	}
}
