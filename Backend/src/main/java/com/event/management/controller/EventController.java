package com.event.management.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.model.Event;
import com.event.management.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/event")
@Api(value = "Event", description = "Event Apis", tags = { "Event" })
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/all")
	@ApiOperation(value = "Get All Events")
	public List<Event> getAllEvents() {

		return eventService.getAllEvents();
	}

	@GetMapping("/{eventId}")
	@ApiOperation(value = "Get Event By Id", response = Event.class)
	public Event getEventById(@PathParam("eventId") int eventId) {
		return eventService.getEventById(eventId);
	}

	@PostMapping("/add")
	@ApiOperation(value = "Add a new Event")
	//@ApiImplicitParam(name = "event", value = "request", required = true, dataType = "Event")
	public Event addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
	}

	@DeleteMapping("/delete/{eventId}")
	@ApiOperation(value = "Delete an existing event")
	public void deleteEventById(@PathParam("eventId") int eventId) {
		eventService.deleteEventById(eventId);
	}

}
