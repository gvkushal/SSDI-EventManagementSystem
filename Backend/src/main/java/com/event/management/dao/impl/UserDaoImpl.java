package com.event.management.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.event.management.advice.EventManagementException;
import com.event.management.advice.InvalidInputException;
import com.event.management.dao.UsersDao;
import com.event.management.model.Users;
import com.event.management.repository.UsersRepository;

@Repository
public class UserDaoImpl implements UsersDao {

	@Autowired
	private UsersRepository repository;

	@Override
	public Users register(Users user) {
		Users existing = repository.getUserByEmail(user.getEmail());
		if (existing != null)
			throw new EventManagementException("User is already exist please use another email");
		repository.save(user);
		return user;
	}

	@Override
	public Users getUserByEmail(String email) {
		return repository.getUserByEmail(email);
	}

	@Override
	@Transactional
	public String updatePassword(String email, String password) {
		Users existing = repository.getUserByEmail(email);
		if (existing == null) {
			throw new InvalidInputException("Cannot update the password, user not exist..!!");
		}
		existing.setPassword(password);
		return "Successfully updated the password";
	}
}
