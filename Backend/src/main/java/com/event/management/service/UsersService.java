package com.event.management.service;

import com.event.management.model.Users;
import com.event.management.model.Login;

public interface UsersService {

	Users register(Users user);

	Users getUserDetails(String email);

	String updatePassword(String email, String password);

	Users getUserById(int usersId);
	
	String login(Login credentials);

}
