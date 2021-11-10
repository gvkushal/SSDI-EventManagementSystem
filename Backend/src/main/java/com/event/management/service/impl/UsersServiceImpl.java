package com.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.UsersDao;
import com.event.management.model.Users;
import com.event.management.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public Users register(Users user) {
		return usersDao.register(user);
	}

	@Override
	public Users getUserDetails(String email) {
		return usersDao.getUserByEmail(email);
	}

	@Override
	public String updatePassword(String email, String password) {
		if (email == null) {
			throw new InvalidInputException("Email Id cannot be empty..!!");
		}
		return usersDao.updatePassword(email, password);
	}
}
