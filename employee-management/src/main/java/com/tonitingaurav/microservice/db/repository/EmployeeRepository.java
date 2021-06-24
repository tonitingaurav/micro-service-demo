package com.tonitingaurav.microservice.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tonitingaurav.microservice.db.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	List<EmployeeEntity> findByUserName(String userName);
}
