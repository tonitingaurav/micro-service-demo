package com.tonitingaurav.microservice.exception;

public class EmployeeAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistException(String message) {
		super(message);
	}

	public EmployeeAlreadyExistException(String message, Throwable e) {
		super(message, e);
	}

}
