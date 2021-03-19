package com.vti.railway08_training.sampleFinalAssignment.frontend;

import com.vti.railway08_training.finalAssignment.utils.ScannerUtils;
import com.vti.railway08_training.sampleFinalAssignment.backend.controller.UserController;

public class ProgramDemo {
	public static void main(String[] args) throws Exception {
		UserController controller = new UserController();
		Login login = new Login();
		
		System.out.println("Please enter the email: ");
		String email = ScannerUtils.inputString();
		System.out.println("Please enter the password: ");
		String password = ScannerUtils.inputString();
		
		if (login.isAdmin(email, password)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}