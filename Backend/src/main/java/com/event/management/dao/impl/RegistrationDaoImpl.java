package com.event.management.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.dao.RegistrationDao;
import com.event.management.repository.RegistrationRepository;

@Service
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private RegistrationRepository repository;
}
