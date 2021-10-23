package com.tcs;

import org.springframework.stereotype.Service;

// Spring creates the object of this class & maintains in the container
@Service
public class HelloService {
	public String greetings(String name) {
		return "Hello "+name;
	}
}
