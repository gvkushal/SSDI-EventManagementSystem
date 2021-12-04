package com.event.management;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.RegistrationDao;
import com.event.management.dao.impl.RegistrationDaoImpl;
import com.event.management.model.Registration;
import com.event.management.model.Users;
import com.event.management.model.Event;
import com.event.management.service.impl.RegistrationServiceImpl;

public class RegisTests {

	@Mock
	RegistrationDao regisDao;

	private RegistrationServiceImpl registrationService;

	private String email = "ssdiTeam@uncc.edu";

	@Before
	public void setUp() {
		regisDao = Mockito.mock(RegistrationDaoImpl.class);
		registrationService = new RegistrationServiceImpl();
		//registrationService.setregisDao(regisDao);
	}

	/*@Test
	public Registration subscribeEvent() {
	
		Registration regist = new Registration();
		regist.setRegistrationId(registrationId);
		Mockito.when(RegistrationDao.getRegistrationById(registrationId)).thenReturn(regist);
		Registration result = getRegistrationById();
		assertEquals(regist, result);
	}*/
	
	@Test
	public void regisID() {
		Registration regist = new Registration();
		
		regist.setRegistrationId(1);
		
		//Mockito.when(RegistrationDao.getRegistrationId(1)).thenReturn(regist);
		assertEquals(regist.getRegistrationId(),1);
	}
	
	/*@Test
	public void createdon() {
    Registration regist = new Registration();
		
		regist.setCreatedOn("2021-12-11T11:11:11");
		
		//Mockito.when(RegistrationDao.getRegistrationId(1)).thenReturn(regist);
		assertEquals(regist.getRegistrationId(),1);
	}*/
	@Test
	public void EVENT1() {
		Registration regist = new Registration();
		Event event=new Event();
		
		regist.setEvent(event);
		
		//Mockito.when(RegistrationDao.getRegistrationId(1)).thenReturn(regist);
		assertEquals(regist.getEvent(),event);
	}
	@Test
	public void User1() {
		Registration regist = new Registration();
		Users user=new Users();
		
		regist.setUsers(user);
		
		assertEquals(regist.getUsers(),user);
	}
	
	
}