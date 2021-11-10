package com.event.management.advice;

public class InvalidInputException extends RuntimeException{

	public InvalidInputException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
