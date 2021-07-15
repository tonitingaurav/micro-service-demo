package com.tonitingaurav.microservice.client.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tonitingaurav.microservice.client.EmployeeManagementClient;
import com.tonitingaurav.microservice.model.Employee;
import com.tonitingaurav.microservice.model.Employees;

import io.github.resilience4j.retry.annotation.Retry;

@Component
public class EmployeeManagementFallback implements EmployeeManagementClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementFallback.class);

	@Autowired
	private EmployeeManagementClient employeeManagementClient;

	@Override
	@Retry(name = "employee-management", fallbackMethod = "getAllAfterRetry")
	//@CircuitBreaker(name = "employee-management", fallbackMethod = "getAllAfterRetry")
	public Employees getAll() {
		LOGGER.info("Get all employees from employee-management service");
		return employeeManagementClient.getAll();
	}

	@Override
	public Employee get(int id) {
		LOGGER.info("Get employee from employee-management service for id {}", id);
		return employeeManagementClient.get(id);
	}
	
	public Employees getAllAfterRetry(Exception e) {
		LOGGER.error("Fallback for exception", e);
		return new Employees();
	}

}
