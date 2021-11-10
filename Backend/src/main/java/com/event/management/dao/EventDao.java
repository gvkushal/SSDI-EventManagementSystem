package com.event.management.dao;

import java.util.List;
import java.util.Optional;

import com.event.management.model.Event;


public interface EventDao {

	List<Event> getAllEvents();

	Optional<Event> getEventById(int eventId);

	Event addEvent(Event event);

	void deleteEvent(Event event);

	void deleteEventById(int eventId);

}
