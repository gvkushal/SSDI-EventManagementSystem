package com.event.management.dao;

import com.event.management.model.Users;
import com.event.management.model.Login;

public interface UsersDao{

	Users register(Users user);

	Users getUserByEmail(String email);

	String updatePassword(String email, String password);

	Users getUserById(int usersId);
	
	String login(Login credentials);

}
