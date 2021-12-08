package com.event.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.event.management.advice.EMSException;
import com.event.management.advice.InvalidInputException;
import com.event.management.dao.RegistrationDao;
import com.event.management.model.Event;
import com.event.management.model.Registration;
import com.event.management.model.Users;
import com.event.management.service.EmailService;
import com.event.management.service.EventService;
import com.event.management.service.RegistrationService;
import com.event.management.service.UsersService;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	@Autowired
	private EventService eventService;

	@Autowired
	private UsersService userService;

	@Autowired
	private EmailService emailService;

	@Override
	public Registration subscribeEvent(int eventId, int usersId) {
		if (eventId <= 0 || usersId <= 0)
			throw new InvalidInputException("Please insert Valid eventId or userId");

		Event event = eventService.getEventById(eventId);
		if (event == null)
			throw new InvalidInputException(eventId + " doesnot exist");

		Users user = userService.getUserById(usersId);
		if (user == null)
			throw new InvalidInputException(usersId + " doesnot exist");

		Registration existingRegistration = registrationDao.getRegistration(eventId, usersId);
		if (existingRegistration != null && existingRegistration.getRegistered().equalsIgnoreCase("Y"))
			throw new InvalidInputException(user.getFirstName() + " already registered for " + event.getEventName());

		if (event.getRemainingCapacity() == 0)
			throw new EMSException(event.getEventName() + " is full. Please apply for any other intrested events");

		Registration registration = registrationDao.subscribeEvent(eventId, usersId);
		event.setRemainingCapacity(event.getRemainingCapacity() - 1);
		eventService.updateEvent(event);
		StringBuilder body = new StringBuilder();
		body.append("Hi ").append(user.getFirstName() + ",").append("\n").append("You have successfully registered to ")
				.append(event.getEventName()).append(" event.");
		String subject = event.getEventName() + " Registration";
		emailService.sendEmail(user.getEmail(), body.toString(), subject);
		return registration;
	}

	@Override
	public void unSubscribeEvent(int eventId, int usersId) {
		Registration existing = registrationDao.getRegistration(eventId, usersId);
		if (existing == null)
			throw new InvalidInputException(
					"No Registration exists for userId: " + usersId + " and eventid: " + eventId);
		registrationDao.unSubscribeEvent(existing);
		Event existingEvent = eventService.getEventById(existing.getEvent().getEventId());
		existingEvent.setRemainingCapacity(existingEvent.getRemainingCapacity() + 1);
		eventService.updateEvent(existingEvent);
	}

	@Override
	public List<Registration> getRegistrationsByUserId(int userId) {
		return registrationDao.getRegistrationsByUserId(userId);
	}

}
