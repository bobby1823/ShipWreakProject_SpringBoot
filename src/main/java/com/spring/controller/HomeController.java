package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller Class
 * */
@RestController
@RequestMapping(value="api/v1")
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String start() {
		return  "/, in root ";		
	}
}
