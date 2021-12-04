package com.event.management.dao;

import java.util.List;

import com.event.management.model.Registration;

public interface RegistrationDao {

	Registration subscribeEvent(int eventId, int usersId);

	Registration getRegistration(int eventId, int usersId);

	Registration getRegistrationById(int registrationId);

	Registration unSubscribeEvent(Registration registration);

	List<Integer> getRegisteredUsers(int eventId);

}
