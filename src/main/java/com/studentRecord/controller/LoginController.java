package com.studentRecord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentRecord.entity.JwtRequest;
import com.studentRecord.entity.JwtResponse;
import com.studentRecord.helper.JwtUtil;
import com.studentRecord.service.CustomUserDetailService;

@RestController
public class LoginController {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(path="/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception
	{
		try
		{
		   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
			
		}catch(BadCredentialsException e)
		{
			throw new Exception("Bad Credentials");
		}
		
		UserDetails user = customUserDetailService.loadUserByUsername(request.getUsername());
		String generatedToken = jwtUtil.generateToken(user);
		
		return ResponseEntity.ok(new JwtResponse(generatedToken));
	}

}
