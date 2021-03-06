package com.event.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.event.management.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	@Query("from registration where user_id = ?2 and event_id = ?1")
	public Registration getRegistration(int eventId, int userId);

	@Query("from registration where event_id = ?1")
	public List<Registration> getRegisterationsByEvent(int eventId);
	
	@Query("from registration where user_id = ?1 and registered = 0")
	public List<Registration> getRegistrationnsByUserId(int userId);

}
