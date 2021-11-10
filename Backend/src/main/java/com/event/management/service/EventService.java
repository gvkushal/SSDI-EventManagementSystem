package com.event.management.service;

import java.util.List;

import com.event.management.model.Event;

public interface EventService {

	Event getEventById(int eventId);

	List<Event> getAllEvents();

	Event addEvent(Event event);

	void deleteEventById(int eventId);

}
