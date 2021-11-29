package com.event.management.dao.impl;

import javax.transaction.Transactional;

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

		Registration registration = new Registration();
		registration.setEvent(eventService.getEventById(eventId));
		registration.setUsers(userService.getUserById(usersId));
		repository.save(registration);
		return registration;
	}

	@Override
	public Registration unSubscribeEvent(Registration registration) {
		return repository.save(registration);
	}

	@Override
	public Registration getRegistration(int eventId, int usersId) {
		return repository.getRegistration(eventId, usersId);
	}

	@Override
	public Registration getRegistrationById(int registrationId) {
		if(!repository.existsById(registrationId))
			return null;
		return repository.findById(registrationId).get();
	}
}
