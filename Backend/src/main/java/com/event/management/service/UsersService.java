package com.event.management.service;

import com.event.management.model.Users;

public interface UsersService {

	Users register(Users user);

	Users getUserDetails(String email);

	String updatePassword(String email, String password);

}
