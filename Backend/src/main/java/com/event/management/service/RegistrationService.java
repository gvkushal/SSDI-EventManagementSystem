package com.event.management.service;

import java.util.List;

import com.event.management.model.Registration;

public interface RegistrationService {

	Registration subscribeEvent(int eventId, int usersId);

	Registration unSubscribeEvent(int registrationId);
	
	List<Registration> getRegistrationsByUserId(int userId);
}
