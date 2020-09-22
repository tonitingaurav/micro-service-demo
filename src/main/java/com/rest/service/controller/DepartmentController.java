package com.rest.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.service.exception.DepartmentNotFoundException;
import com.rest.service.model.Department;

@RestController
@RequestMapping("/department")
@Api(value = "Department CURD Operations", tags = { "Department" })
public class DepartmentController {

	private static Map<Integer, Department> data = new HashMap<>();

	private static int count = 0;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Department Detils")
	public ResponseEntity<Object> getDepartment(@PathVariable("id") int id) {
		Department department = data.get(id);
		if (department == null) {
			throw new DepartmentNotFoundException("Department with id " + id + " not found");
		}
		return ResponseEntity.ok(department);
	}

	@PostMapping
	public ResponseEntity<Object> saveDepartment(@RequestBody Department department) {
		int id = ++count;
		data.put(id, department);
		department.setId(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

}
