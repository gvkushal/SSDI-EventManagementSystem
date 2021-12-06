package com.event.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.model.Registration;
import com.event.management.model.SubscribeRequest;
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
	public Registration subscribeEvent(@RequestBody SubscribeRequest request) {

		if (request.getSubscribe().equalsIgnoreCase("Y")) {
			return service.subscribeEvent(request.getEventId(), request.getUsersId());
		} else {
			service.unSubscribeEvent(request.getEventId(), request.getUsersId());
		}
		return null;
	}

	/*
	 * @PutMapping("/unsubscribe/event")
	 * 
	 * @ApiOperation(value = "Unsubscribe for an event", response =
	 * Registration.class) public void unSubscribeEvent(@RequestParam int
	 * registrationId) { service.unSubscribeEvent(registrationId); }
	 */

	@GetMapping("/subscribed/{userId}")
	@ApiOperation(value = "Get all user subscriptions by users id", response = ArrayList.class)
	public List<Integer> getRegistrationsByUserId(@PathParam("userId") int userId) {
		List<Registration> regs = service.getRegistrationsByUserId(userId);
		List<Integer> eventIds = new ArrayList<>();
		for (Registration reg : regs) {
			eventIds.add(reg.getEvent().getEventId());
		}
		return eventIds;
	}

}
