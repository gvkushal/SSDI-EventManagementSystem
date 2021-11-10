package com.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
