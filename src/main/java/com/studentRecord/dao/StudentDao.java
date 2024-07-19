package com.studentRecord.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentRecord.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
