package com.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.RegistrationDao;
import com.event.management.model.Event;
import com.event.management.model.Registration;
import com.event.management.model.Users;
import com.event.management.service.EventService;
import com.event.management.service.RegistrationService;
import com.event.management.service.UsersService;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	@Override
	public Registration subscribeEvent(int eventId, int usersId) {
		if (eventId <= 0 || usersId <= 0)
			throw new InvalidInputException("Please insert Valid eventId or userId");

		return registrationDao.subscribeEvent(eventId, usersId);

	}

}
