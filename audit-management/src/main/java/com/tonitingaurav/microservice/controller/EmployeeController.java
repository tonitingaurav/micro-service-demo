package com.tonitingaurav.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonitingaurav.microservice.client.fallback.EmployeeManagementFallback;
import com.tonitingaurav.microservice.model.Employee;
import com.tonitingaurav.microservice.model.Employees;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee CURD Operations", tags = { "employee" })
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeManagementFallback employeeManagementClient;

	@GetMapping
	@ApiOperation(value = "Get All Employees Detils")
	public ResponseEntity<Employees> getAll() {
		LOGGER.info("Getting All Employees");
		return ResponseEntity.ok(employeeManagementClient.getAll());
	}

	@GetMapping
	@RequestMapping("/{id}")
	@ApiOperation(value = "Get Employee Details")
	public ResponseEntity<Employee> get(@PathVariable("id") int id) {
		return ResponseEntity.ok(employeeManagementClient.get(id));
	}
}
