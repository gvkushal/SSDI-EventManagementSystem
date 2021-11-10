package com.event.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.EventDao;
import com.event.management.model.Event;
import com.event.management.service.EventService;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public Event getEventById(int eventId) {
		if (eventId < 0) {
			throw new InvalidInputException("Please provide valid eventId");
		}
		Optional<Event> event = eventDao.getEventById(eventId);
		if (!event.isPresent())
			throw new InvalidInputException("No event with event id: " + eventId);
		return event.get();
	}

	@Override
	public Event addEvent(Event event) {
		if (event == null /*|| event.getEventStartTime() == null || event.getEventEndTime() == null*/)
			throw new InvalidInputException("Please provide valid event data");
		return eventDao.addEvent(event);

	}

	@Override
	public void deleteEventById(int eventId) {
		if (eventId < 0)
			throw new InvalidInputException("Please provide valid eventId");
		Optional<Event> eventInfo = eventDao.getEventById(eventId);
		if (!eventInfo.isPresent())
			throw new InvalidInputException("No event with event id: " + eventId);
		eventDao.deleteEvent(eventInfo.get());
	}

}
