package com.event.management.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.event.management.dao.EventDao;
import com.event.management.model.Event;
import com.event.management.repository.EventRepository;

@Service
public class EventDaoImpl implements EventDao {

	@Autowired
	private EventRepository repository;

	@Override
	public List<Event> getAllEvents() {
		return repository.findAll(Sort.by("eventStartTime").ascending());
	}

	@Override
	public Optional<Event> getEventById(int eventId) {
		return repository.findById(eventId);
	}

	@Override
	public Event addEvent(Event event) {
		return repository.save(event);
	}

/*	public Event updateEvent(Event event) {
//		if (event.getEventId() > 0)  
//		return repository.
	}*/
	
	@Override
	public void deleteEvent(Event event) {
		repository.delete(event);
	}

	@Override
	public void deleteEventById(int eventId) {
		repository.deleteById(eventId);
	}
}
