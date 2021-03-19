package com.vti.railway08_training.sampleFinalAssignment.frontend;

import com.vti.railway08_training.finalAssignment.utils.CheckUtils;
import com.vti.railway08_training.sampleFinalAssignment.backend.controller.UserController;

public class Login {
	private UserController controller;
	
	public Login( ) {
		controller = new UserController();
	}
	
	public boolean isAdmin(String email, String password) throws Exception {
		if (!CheckUtils.isEmailValid(email)) {
			throw new Exception("Your email is not valid, please check again!");
		}
		if (!controller.isEmailExists(email)) {
			throw new Exception("This email is not exists on the system!");
		}
		return controller.isAdmin(email, password);
	}
}
