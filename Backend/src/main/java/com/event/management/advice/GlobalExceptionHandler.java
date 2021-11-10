package com.event.management.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(value=InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInput(InvalidInputException invalidInput) {
		return new ResponseEntity<String>(invalidInput.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=EventManagementException.class)
	public ResponseEntity<String> handleEventManagementException(EventManagementException invalid) {
		return new ResponseEntity<String>(invalid.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
