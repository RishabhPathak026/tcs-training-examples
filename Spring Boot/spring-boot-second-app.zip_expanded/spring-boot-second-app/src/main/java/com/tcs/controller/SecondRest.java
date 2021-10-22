package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.service.SecondService;

@RestController
@RequestMapping("second-rest")
public class SecondRest {
	
	@Autowired
	private SecondService service;
	@GetMapping("/hello")
	public String test() {
		return service.greetings();
	}
}
