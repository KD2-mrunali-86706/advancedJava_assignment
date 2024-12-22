package com.commerce.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseDTO {
	
	private Long id;
	
	private LocalDate createdOon;
	
	private LocalDate updatedOon;

}
