package com.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.model.Registration;
import com.event.management.service.RegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/registration")
@Api(value = "Registration", description = "Registration Apis", tags = { "Registration" })
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping("/subscribe/event")
	@ApiOperation(value = "Subscribe for an event", response = Registration.class)
	public Registration subscribeEvent(@RequestParam int eventId, @RequestParam int usersId) {
		return service.subscribeEvent(eventId, usersId);
	}

	@PutMapping("/unsubscribe/event")
	@ApiOperation(value = "Unsubscribe for an event", response = Registration.class)
	public Registration unSubscribeEvent(@RequestParam int registrationId) {
		return service.unSubscribeEvent(registrationId);
	}

}
