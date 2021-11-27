package com.event.management.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.RegistrationDao;
import com.event.management.model.Event;
import com.event.management.model.Registration;
import com.event.management.model.Users;
import com.event.management.repository.RegistrationRepository;
import com.event.management.service.EventService;
import com.event.management.service.UsersService;

@Service
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private RegistrationRepository repository;

	@Autowired
	private EventService eventService;

	@Autowired
	private UsersService userService;

	@Override
	public Registration subscribeEvent(int eventId, int usersId) {
		Event event = eventService.getEventById(eventId);
		if (event == null)
			throw new InvalidInputException(eventId + " doesnot exist");
		Users user = userService.getUserById(usersId);
		if (user == null)
			throw new InvalidInputException(usersId + " doesnot exist");
		Registration registration = new Registration();
		registration.setEvent(event);
		registration.setUsers(user);
		repository.save(registration);
		return registration;
		
		//catch already registered user and throw error msg
		//check the cpacity and add accordingly.
	}
}
