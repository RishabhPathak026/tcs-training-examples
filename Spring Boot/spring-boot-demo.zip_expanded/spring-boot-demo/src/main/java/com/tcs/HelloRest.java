package com.tcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
// its a controller layer code 
=======

>>>>>>> 0b37b6f05a5e974533d9510117a7d9f12193da60
@RestController
@RequestMapping("welcome")
public class HelloRest {

<<<<<<< HEAD
	// inject the service using @Autowired
	@Autowired
	HelloService service;
	
	// you can get the message using the URL: http://ip:port/application-url/other-urls, 
	// http://localhost:8080/welcome/test
=======
	
	@Autowired
	HelloService service;
	
	
>>>>>>> 0b37b6f05a5e974533d9510117a7d9f12193da60
	@GetMapping("/test")
	public String hello() {
		return service.greetings("Raj");
	}
}
