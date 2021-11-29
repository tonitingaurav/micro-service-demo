package com.tonitingaurav.microservice.audit;

public class Log {

	public Log() {
		super();
	}

	public Log(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
