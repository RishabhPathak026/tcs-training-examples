package com.tcs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("first-api")
public class FirstRest {
	
	@GetMapping
	public String hello() {
		return "Welcome to First Microservice";
	}
}
