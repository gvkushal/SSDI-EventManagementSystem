package com.event.management.service;

import com.event.management.model.Registration;

public interface RegistrationService {

	Registration subscribeEvent(int eventId, int usersId);

}
