package com.studentRecord.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private Long rollNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Long rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public Student(String name, Long rollNumber, Address address) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	}
