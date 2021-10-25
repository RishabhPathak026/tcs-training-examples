package com.tcs.exceptions;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message) {
		super(message);
	}	
}
