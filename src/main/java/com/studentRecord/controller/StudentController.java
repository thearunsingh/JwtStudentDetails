package com.studentRecord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentRecord.entity.Student;
import com.studentRecord.service.StudentService;



@RestController
@RequestMapping("/studentDetails")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(path="/",method=RequestMethod.GET)
	public Iterable<Student> getStudent()
	{
		return studentService.getStudent();
	}
	
	@RequestMapping(path="/register",method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student)
	{
	   studentService.addStudent(student);
	   return new ResponseEntity<>(HttpStatus.OK);
	   
	}
}
