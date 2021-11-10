package com.event.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.advice.InvalidInputException;
import com.event.management.model.Users;
import com.event.management.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(value = "User", description = "User Apis", tags = { "User" })
public class UsersController {

	@Autowired
	private UsersService usersService;;

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@PostMapping("/register")
	@ApiOperation(value = "Register a user")
	public ResponseEntity<Users> register(@RequestBody Users user) {
		if (user == null)
			throw new InvalidInputException("User cannot be null. please provide valid input");
		if (user.getEmail() == null || user.getEmail().isEmpty() || user.getPassword() == null)
			throw new InvalidInputException("Please provide valid user detials");
		return new ResponseEntity<Users>(usersService.register(user), HttpStatus.ACCEPTED);
	}

	@GetMapping()
	@ApiOperation(value = "Getting User by email")
	public ResponseEntity<Users> getUserDetails(String email) {
		return new ResponseEntity<Users>(usersService.getUserDetails(email), HttpStatus.ACCEPTED);
	}

	@PutMapping("/updatePassword")
	@ApiOperation(value = "Update Password for a user")
	public ResponseEntity<String> updatePassword(@RequestParam String email, @RequestParam String password) {
		return new ResponseEntity<String>(usersService.updatePassword(email, password), HttpStatus.ACCEPTED);
	}

}
