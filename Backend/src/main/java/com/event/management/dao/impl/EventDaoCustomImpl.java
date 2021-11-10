package com.event.management.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.dao.EventDaoCustom;
import com.event.management.model.Event;

@Service
public class EventDaoCustomImpl implements EventDaoCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Event> getEvents() {
		List<Event> events = null;
		try {
			String query = "from event";
			Query q = entityManager.createQuery(query);
			events = (List<Event>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return events;
	}
}
