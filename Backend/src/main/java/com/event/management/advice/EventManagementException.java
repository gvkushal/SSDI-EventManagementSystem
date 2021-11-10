package com.event.management.advice;

public class EventManagementException extends RuntimeException{

	public EventManagementException() {
		super();
	}
	
	public EventManagementException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
