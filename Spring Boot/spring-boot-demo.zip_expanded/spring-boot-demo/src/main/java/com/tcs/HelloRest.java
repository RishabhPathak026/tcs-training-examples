package com.tcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// its a controller layer code 
@RestController
@RequestMapping("welcome")
public class HelloRest {

	// inject the service using @Autowired
	@Autowired
	HelloService service;
	
	// you can get the message using the URL: http://ip:port/application-url/other-urls, 
	// http://localhost:8080/welcome/test
	@GetMapping("/test")
	public String hello() {
		return service.greetings("Raj");
	}
}
