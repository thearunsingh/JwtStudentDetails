package com.studentRecord.service;

import java.util.List;
import java.util.UUID;

import com.studentRecord.entity.Student;

public interface StudentService {
	
	public Iterable<Student> getStudent();
	public void addStudent(Student Student);
	public Student getStudentById(int id);
	
	

}
