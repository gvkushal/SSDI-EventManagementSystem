package com.event.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin
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

	@GetMapping("/subscribed/{userId}")
	@ApiOperation(value = "Get all user subscriptions by users id", response = Registration.class)
	public List<Registration> getRegistrationsByUserId(@PathParam("userId") int userId) {
		return service.getRegistrationsByUserId(userId);
	}

}
