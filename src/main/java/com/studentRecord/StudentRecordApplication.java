package com.studentRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.studentRecord.dao.AddressDao;
import com.studentRecord.dao.CountryDao;
import com.studentRecord.dao.StudentDao;
import com.studentRecord.dao.UserDao;
import com.studentRecord.entity.Address;
import com.studentRecord.entity.Country;
import com.studentRecord.entity.Student;
import com.studentRecord.entity.Users;

@SpringBootApplication
public class StudentRecordApplication implements CommandLineRunner{
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users usr= new Users();
		usr.setUsername("Arun");
		usr.setPassword(this.passwordEncoder.encode("Arun"));
		usr.setEmail("arunsingh456@gmail.com");
		usr.setRole("ROLE_ADMIN");
		userdao.save(usr);
		
		Users usr1= new Users();
		usr1.setUsername("Abhi");
		usr1.setPassword(this.passwordEncoder.encode("Abhi"));
		usr1.setEmail("abhisingh456@gmail.com");
		usr1.setRole("ROLE_NORMAL");
		userdao.save(usr1);
		
	}

}
