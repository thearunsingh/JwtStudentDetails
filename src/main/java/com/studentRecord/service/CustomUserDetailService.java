package com.studentRecord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentRecord.dao.UserDao;
import com.studentRecord.entity.CustomUserDetail;
import com.studentRecord.entity.Users;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users userName = this.userDao.findbyUserName(username);
		if(userName==null)
		{
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetail(userName);
	}

}
