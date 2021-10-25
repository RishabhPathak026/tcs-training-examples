package com.tcs;

import org.springframework.stereotype.Service;


@Service
public class HelloService {
	public String greetings(String name) {
		return "Hello "+name;
	}
}
