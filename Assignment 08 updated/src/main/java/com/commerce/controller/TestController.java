package com.commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping("/")
	public String testController(){
		System.out.println("working constructor");
		
        return "heeloo";		
	}

}
