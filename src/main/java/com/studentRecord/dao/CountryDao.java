package com.studentRecord.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentRecord.entity.Country;

@Repository
public interface CountryDao extends JpaRepository<Country, Long>{

	@Query(value = "SELECT * FROM country WHERE name ilike :name", nativeQuery = true)
    Country getCountryId(@Param("name") String name);
}
