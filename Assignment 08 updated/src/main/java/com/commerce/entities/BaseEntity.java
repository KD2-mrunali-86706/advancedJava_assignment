package com.commerce.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@MappedSuperclass
@Getter
@Setter
@ToString

public class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDate createdOon;
	@UpdateTimestamp
	private LocalDate updatedOon;
	
	
	
	public BaseEntity() {
		super();
		
	}

	
	
}
