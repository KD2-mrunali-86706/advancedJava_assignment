package com.blogs.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class ApiResponse {
	
	
	
	
	
	public ApiResponse() {
		
	}
	private String message;
	private LocalDateTime timeStamp;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
}
