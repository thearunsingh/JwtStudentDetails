package com.studentRecord.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.studentRecord.dao.UserDao;
import com.studentRecord.entity.Address;
import com.studentRecord.entity.Student;
import com.studentRecord.entity.Users;

@ExtendWith(value = {MockitoExtension.class})
@TestInstance(value = Lifecycle.PER_CLASS)
public class UserServiceTest {
	
	@Mock
	private UserDao repo;
	
	@InjectMocks
	private CustomUserDetailService service;
	
	@Test
	public void getStudentByIdTest()
	{
		Users usr = new Users("arunsingh", "Arun123", "arunsingh@gmail.com");
		when(repo.findbyUserName("arunsingh")).thenReturn(usr);
		
		Users users = service.getUserByName("arunsingh");
		assertEquals("arunsingh@gmail.com", users.getEmail());
	}
	
}
