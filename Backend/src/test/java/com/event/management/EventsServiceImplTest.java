package com.event.management;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.EventDao;
import com.event.management.dao.impl.EventDaoImpl;
import com.event.management.model.Event;
import com.event.management.service.impl.EventServiceImpl;

public class EventsServiceImplTest {

	@Mock
	private EventDao eventDao;

	private EventServiceImpl eventService;

	@Before
	public void setUp() {
		eventDao = Mockito.mock(EventDaoImpl.class);
		eventService = new EventServiceImpl();
		eventService.setEventDao(eventDao);
	}

	@Test(expected = InvalidInputException.class)
	public void getEventById_InvalidException() {
		eventService.getEventById(-1);
	}

	@Test
	public void getEventById_HappyFlow() {
		Event event = new Event();
		event.setEventId(10);
		event.setEventName("newEvent");
		Optional<Event> optional = Optional.of(event);
		Mockito.when(eventDao.getEventById(10)).thenReturn(optional);
		Event expected = eventService.getEventById(10);
		assertEquals(expected, event);
	}

	@Test(expected = InvalidInputException.class)
	public void getEventById_NoEvent() {
		Optional<Event> optional = Optional.empty();
		Mockito.when(eventDao.getEventById(10)).thenReturn(optional);
		eventService.getEventById(10);
	}

	@Test(expected = InvalidInputException.class)
	public void addEvent_null() {
		eventService.addEvent(null);
	}

	@Test
	public void addEvent_happyflow() {
		Event event = new Event();
		Mockito.when(eventDao.addEvent(event)).thenReturn(event);
		eventDao.addEvent(event);
		Event added = eventService.addEvent(event);
		assertEquals(added, event);
	}

	@Test(expected = InvalidInputException.class)
	public void deleteEventById_NegativeEventId() {
		eventService.deleteEventById(-1);
	}

	@Test
	public void deleteEventById_happyflow() {
		Event event = new Event();
		event.setEventId(11);
		event.setEventName("newEvent");
		Optional<Event> optional = Optional.of(event);
		Mockito.when(eventDao.getEventById(11)).thenReturn(optional);
		eventService.deleteEventById(11);
		Mockito.verify(eventDao, Mockito.times(1)).getEventById(11);
	}

	@Test(expected = InvalidInputException.class)
	public void deleteEventById_NoExists() {
		Optional<Event> optional = Optional.empty();
		Mockito.when(eventDao.getEventById(12)).thenReturn(optional);
		eventService.deleteEventById(12);
		Mockito.verify(eventDao, Mockito.times(1)).getEventById(11);
	}
}
