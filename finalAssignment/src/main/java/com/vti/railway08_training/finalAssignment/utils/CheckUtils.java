package com.vti.railway08_training.finalAssignment.utils;

import java.util.regex.Pattern;

public class CheckUtils {

	public boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

//	Password should not contain any space.
//	Password should contain at least one digit(0-9).
//	Password length should be between 8 to 15 characters.
//	Password should contain at least one lower case letter(a-z).
//	Password should contain at least one upper case letter(A-Z).
//	Password should contain at least one special character ( @, #, %, &, !, $, etc….).

	public boolean isPasswordValid(String password) {

		// for checking if password length
		// is between 8 and 15
		if (!((password.length() >= 8) && (password.length() <= 15))) {
			return false;
		}

		// to check space
		if (password.contains(" ")) {
			return false;
		}
		if (true) {
			int count = 0;

			// check digits from 0 to 9
			for (int i = 0; i <= 9; i++) {

				// to convert int to string
				String str1 = Integer.toString(i);

				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		// for special characters
		if (!(password.contains("@") || password.contains("#") || password.contains("!") || password.contains("~")
				|| password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&")
				|| password.contains("*") || password.contains("(") || password.contains(")") || password.contains("-")
				|| password.contains("+") || password.contains("/") || password.contains(":") || password.contains(".")
				|| password.contains(", ") || password.contains("<") || password.contains(">") || password.contains("?")
				|| password.contains("|"))) {
			return false;
		}

		if (true) {
			int count = 0;

			// checking capital letters
			for (int i = 65; i <= 90; i++) {

				// type casting
				char c = (char) i;

				String str1 = Character.toString(c);
				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		if (true) {
			int count = 0;

			// checking small letters
			for (int i = 90; i <= 122; i++) {

				// type casting
				char c = (char) i;
				String str1 = Character.toString(c);

				if (password.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		// if all conditions fails
		return true;
	}

	public void passwordRequirement() {
		System.out.println("//	Password should not contain any space.\r\n"
				+ "//	Password should contain at least one digit(0-9).\r\n"
				+ "//	Password length should be between 8 to 15 characters.\r\n"
				+ "//	Password should contain at least one lower case letter(a-z).\r\n"
				+ "//	Password should contain at least one upper case letter(A-Z).\r\n"
				+ "//	Password should contain at least one special character ( @, #, %, &, !, $, etc….).");
	}
}
