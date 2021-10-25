package com.tcs.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}	
}
