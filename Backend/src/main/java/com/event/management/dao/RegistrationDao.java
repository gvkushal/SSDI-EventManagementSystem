package com.event.management.dao;

import com.event.management.model.Registration;

public interface RegistrationDao {

	Registration subscribeEvent(int eventId, int usersId);

}
