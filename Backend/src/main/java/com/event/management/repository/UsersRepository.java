package com.event.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.event.management.dao.UsersDaoCustom;
import com.event.management.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> , UsersDaoCustom{

	@Query(value = "from users where email = ?1")
	public Users getUserByEmail(String email);
}
