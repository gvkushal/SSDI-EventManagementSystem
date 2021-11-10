package com.event.management;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.event.management.advice.InvalidInputException;
import com.event.management.dao.UsersDao;
import com.event.management.dao.impl.UserDaoImpl;
import com.event.management.model.Users;
import com.event.management.service.impl.UsersServiceImpl;

public class UsersServiceImplTest {

	@Mock
	UsersDao usersDao;

	private UsersServiceImpl usersService;

	private String email = "ssdiTeam@uncc.edu";

	@Before
	public void setUp() {
		usersDao = Mockito.mock(UserDaoImpl.class);
		usersService = new UsersServiceImpl();
		usersService.setUsersDao(usersDao);
	}

	@Test
	public void getUserDetails_happyflow() {
		Users user = new Users();
		user.setEmail(email);
		Mockito.when(usersDao.getUserByEmail(email)).thenReturn(user);
		Users result = usersService.getUserDetails(email);
		assertEquals(user, result);
	}

	@Test
	public void register_happyflow() {
		Users user = new Users();
		user.setEmail(email);
		user.setFirstName("Dave");
		user.setLastName("Hopkins");
		Mockito.when(usersDao.register(user)).thenReturn(user);
		Users result = usersService.register(user);
		assertEquals(result, user);
	}

	@Test(expected = InvalidInputException.class)
	public void register_existing_user_exception() {
		Users user = new Users();
		user.setEmail(email);
		user.setFirstName("Dave");
		user.setLastName("Hopkins");
		Mockito.when(usersDao.register(user)).thenThrow(new InvalidInputException("User Already Exist"));
		usersService.register(user);
	}

	@Test(expected = InvalidInputException.class)
	public void updatePassword_email_null() {
		usersService.updatePassword(null, "qwueyry!5");
	}
	
	@Test
	public void updatePassword_happyflow() {
		Mockito.when(usersDao.updatePassword(email, "Qwueyry$5")).thenReturn("Successfully updated the password");
		String result = usersService.updatePassword(email, "Qwueyry$5");
		assertEquals(result,"Successfully updated the password");
	}

}
