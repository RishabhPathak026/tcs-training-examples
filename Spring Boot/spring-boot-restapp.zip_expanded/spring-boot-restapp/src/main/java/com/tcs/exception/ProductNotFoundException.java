package com.tcs.exception;



@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String error) {
		super(error);
	}
}
/*
 * if code uses throw new EmployeeNotFoundException("some message");
 * in the catch block you can read those messages using getMessage()
 * like printStackTracke(), you also have getMessage() in Exception 
 * class
 */

