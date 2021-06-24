package com.tonitingaurav.microservice.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tonitingaurav.microservice.exception.EmployeeAlreadyExistException;
import com.tonitingaurav.microservice.exception.EmployeeNotFoundException;
import com.tonitingaurav.microservice.model.ExceptionResponse;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) throws Exception {
		LOGGER.error(ex.getMessage(), ex);
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage("Exception for context path " + request.getContextPath());
		exceptionResponse.setMessageType("Error");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ EmployeeAlreadyExistException.class })
	public final ResponseEntity<ExceptionResponse> handleDepartmentNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = createExceptionResponse(ex);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ EmployeeNotFoundException.class })
	public final ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = createExceptionResponse(ex);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	private ExceptionResponse createExceptionResponse(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessageType("Error");
		exceptionResponse.setMessage(ex.getMessage());
		return exceptionResponse;
	}

	@Override
	// This method is called when an input validation is failed
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(ex.getMessage(), ex);
		ExceptionResponse exceptionResponse = new ExceptionResponse("Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
