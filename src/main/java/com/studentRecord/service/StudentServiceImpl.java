package com.studentRecord.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentRecord.dao.AddressDao;
import com.studentRecord.dao.CountryDao;
import com.studentRecord.dao.StudentDao;
import com.studentRecord.entity.Address;
import com.studentRecord.entity.Country;
import com.studentRecord.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private AddressDao addressdao;
	
	@Autowired
	private CountryDao countrydao;
	
	public Country getCountryId(String name)
	{
		return countrydao.getCountryId(name);
	}
	

	@Override
	public Iterable<Student> getStudent() {
		// TODO Auto-generated method stub
		return studentdao.findAll();
	}

	@Override
	public void addStudent(Student student) {
		
		Student stud = new Student();
		stud.setName(student.getName());
		stud.setRollNumber(student.getRollNumber());
		
		Address add = new Address();
		add.setDist(student.getAddress().getDist());
		add.setState(student.getAddress().getState());
		add.setVill(student.getAddress().getVill());
		
		Country cntry = getCountryId(student.getAddress().getCountry().getName());
		
		if(cntry==null)
		{
		cntry = new Country();
		cntry.setName(student.getAddress().getCountry().getName());
		cntry = countrydao.save(cntry);
		}
		
		add.setCountry(cntry);
		
		add = addressdao.save(add);
		
		stud.setAddress(add);
		
		studentdao.save(stud);
	}

	
	

}