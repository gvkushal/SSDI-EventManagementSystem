package com.event.management.dao;

import java.util.List;

import com.event.management.model.Registration;

public interface RegistrationDao {

	Registration subscribeEvent(int eventId, int usersId);

	Registration getRegistration(int eventId, int usersId);

	Registration getRegistrationById(int registrationId);

	void unSubscribeEvent(Registration registration);

	List<Registration> getRegistrationsByEvent(int eventId);

	List<Registration> getRegistrationsByUserId(int userId);

}
