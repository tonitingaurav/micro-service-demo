package com.tonitingaurav.microservice.model;

public class ExceptionResponse {

	private String message;

	private String messageType;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String message, String messageType) {
		super();
		this.message = message;
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
