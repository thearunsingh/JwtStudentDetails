package com.studentRecord.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentRecord.entity.Users;

public interface UserDao extends JpaRepository<Users, String>{

	@Query(value = "SELECT * FROM users WHERE username ilike :username", nativeQuery = true)
	public Users findbyUserName(String username);

}
