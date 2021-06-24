package com.tonitingaurav.microservice.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
