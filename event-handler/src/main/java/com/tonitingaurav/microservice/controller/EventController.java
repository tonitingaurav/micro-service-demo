package com.tonitingaurav.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/event")
@Api(value = "Event Operations", tags = { "event" })
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	@GetMapping
	@ApiOperation(value = "Get All Employees Detils")
	public ResponseEntity<String> getAll() {
		LOGGER.info("Getting All Employees");
		return ResponseEntity.ok("Hello World");
	}

}
