package com.tonitingaurav.microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tonitingaurav.microservice.model.Employee;
import com.tonitingaurav.microservice.model.Employees;

@FeignClient(name = "employee-management")
public interface EmployeeManagementClient {

	@GetMapping("/employee")
	Employees getAll();
	
	@GetMapping("/employee/{id}")
	Employee get(@PathVariable("id") int id);
}
