package com.tonitingaurav.microservice.db.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonitingaurav.microservice.db.entity.EmployeeEntity;
import com.tonitingaurav.microservice.db.repository.EmployeeRepository;
import com.tonitingaurav.microservice.exception.EmployeeAlreadyExistException;
import com.tonitingaurav.microservice.exception.EmployeeNotFoundException;
import com.tonitingaurav.microservice.model.Employee;
import com.tonitingaurav.microservice.model.Employees;

@Service
public class EmployeeEntityService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employees getAll() {
		List<EmployeeEntity> allEmpEntities = employeeRepository.findAll();
		Employees employees = new Employees();
		if (CollectionUtils.isNotEmpty(allEmpEntities)) {
			employees.setEmployees(allEmpEntities.stream().map(e -> modelMapper.map(e, Employee.class)).collect(Collectors.toList()));
		}
		return employees;
	}

	public Integer add(Employee employee) {
		String userName = employee.getUserName();
		List<EmployeeEntity> existingUser = employeeRepository.findByUserName(userName);
		if (CollectionUtils.isNotEmpty(existingUser)) {
			throw new EmployeeAlreadyExistException("Employee with username " + userName + " already exists");
		}
		EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
		employeeEntity = employeeRepository.save(employeeEntity);
		return employeeEntity.getId();
	}

	public Employee get(int id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseGet(() -> null);
		if (employeeEntity == null) {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
		}
		return modelMapper.map(employeeEntity, Employee.class);
	}
}
