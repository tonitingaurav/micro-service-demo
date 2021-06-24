package com.tonitingaurav.microservice.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tonitingaurav.microservice.db.service.EmployeeEntityService;
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
	private EmployeeEntityService employeeEntityService;

	@Value("${spring.jackson.date-format}")
	private String dateFormat;

	@GetMapping
	@ApiOperation(value = "Get All Employees Detils")
	public ResponseEntity<Employees> getAll() {
		LOGGER.info("Getting All Employees");
		return ResponseEntity.ok(employeeEntityService.getAll());
	}

	@GetMapping
	@RequestMapping("/{id}")
	@ApiOperation(value = "Get Employee Details")
	public ResponseEntity<Object> get(@PathVariable("id") int id) {
		return ResponseEntity.ok(employeeEntityService.get(id));
	}

	@PostMapping
	@ApiOperation(value = "Create an employee in the system")
	public ResponseEntity<Object> create(@Valid @RequestBody Employee employee) {
		Integer employeeID = employeeEntityService.add(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeID).toUri();
		return ResponseEntity.created(location).build();
	}
}
