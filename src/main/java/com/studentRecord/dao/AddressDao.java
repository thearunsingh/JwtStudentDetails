package com.studentRecord.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentRecord.entity.Address;


public interface AddressDao extends JpaRepository<Address, Long>{

}
