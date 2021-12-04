package com.event.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.EventDao;
import com.event.management.dao.RegistrationDao;
import com.event.management.dao.UsersDao;
import com.event.management.model.Event;
import com.event.management.model.Registration;
import com.event.management.model.Users;
import com.event.management.service.EmailService;
import com.event.management.service.EventService;
import com.event.management.service.RegistrationService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Autowired
	private EmailService emailService;

	@Autowired
	private RegistrationDao registrationDao;

	@Autowired
	private UsersDao usersDao;

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
		if (event == null || event.getStartTime() == null || event.getEndTime() == null)
			throw new InvalidInputException("Please provide valid event data");
		return eventDao.addOrUpdateEvent(event);

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

	@Override
	public Event updateEvent(Event event) {
		Optional<Event> existing = eventDao.getEventById(event.getEventId());
		if (!existing.isPresent())
			throw new InvalidInputException("No event with event id: " + event.getEventId());
		if (existing.get().getCapactiy() != event.getCapactiy()) {
			if (existing.get().getCapactiy() > event.getCapactiy()
					&& event.getCapactiy() < event.getRemainingCapacity())
				throw new InvalidInputException("Capacity of the " + event.getEventName()
						+ " event cannot be reduced beyond remaining capacity");

			if (existing.get().getCapactiy() < event.getCapactiy()) {
				int diff = event.getCapactiy() - existing.get().getCapactiy();
				event.setCapactiy(event.getCapactiy());
				event.setRemainingCapacity(event.getRemainingCapacity() + diff);
			}

		}

		if (!event.getStartTime().isEqual(existing.get().getStartTime())) {
			List<Registration> registerations = registrationDao.getRegistrationsByEvent(event.getEventId());
			if (!registerations.isEmpty()) {
				String body = new StringBuilder().append("Hi ").append("%s ,").append("\n").append("Event ")
						.append(event.getEventName()).append(" has updated start time from ")
						.append(existing.get().getStartTime()).append(" to ").append(event.getStartTime())
						.append("\n \n").append("Thank You").toString();
				String subject = event.getEventName() + " Registration";
				for (Registration reg : registerations) {
					String formatedBody = String.format(body, reg.getUsers().getFirstName());
					emailService.sendEmail(reg.getUsers().getEmail(), formatedBody, subject);
				}
			}
		}

		Event updatedEvent = eventDao.addOrUpdateEvent(event);
		return updatedEvent;

	}

}
