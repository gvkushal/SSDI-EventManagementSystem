package com.event.management;


import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.EventDao;
import com.event.management.dao.RegistrationDao;
import com.event.management.dao.impl.EventDaoImpl;
import com.event.management.dao.impl.RegistrationDaoImpl;
import com.event.management.model.Registration;
import com.event.management.service.impl.EventServiceImpl;
import com.event.management.service.impl.RegistrationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;




public class RegistrationServiceImplTests {
	
	@Test(expected=InvalidInputException.class)
	public void subscribeEvent() {
	   RegistrationServiceImpl junit= new RegistrationServiceImpl();
	 
	 junit.subscribeEvent(0,0);
	   
	}
	
	@Test(expected=InvalidInputException.class)
	public void subscribeEvent1() {
	   RegistrationServiceImpl junit= new RegistrationServiceImpl();
	 
	 junit.subscribeEvent(0,-1);
	   
	}
	
	@Test(expected=InvalidInputException.class)
	public void unSubscribeEvent() {
	   RegistrationServiceImpl junit= new RegistrationServiceImpl();
	 
	 junit.subscribeEvent(-9,-99);
	   
	}
    
	
}