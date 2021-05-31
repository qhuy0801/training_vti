package com.trainingvti.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingvti.dto.UserDTO;
import com.trainingvti.entity.User;
import com.trainingvti.service.AccountService;

@RestController
@RequestMapping(value = "api/v1/login")
public class LoginController {
	@Autowired
	private AccountService userService;

	@GetMapping
	public UserDTO login(Principal principal) {
		String username = principal.getName();
		User user = userService.findByUserName(username);
		UserDTO userDTO = new UserDTO(user.getId(), 
				user.getUserName(),
				user.getEmail(),
				user.getFirstName(),
				user.getLastName(),
				user.getFullName(),
				user.getRole());
		return userDTO;
	}
}
