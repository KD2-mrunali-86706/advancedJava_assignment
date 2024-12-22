package com.commerce.dto;

import java.time.LocalDate;

import com.commerce.entities.UserRole;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO  extends BaseDTO{
	private  String productTitle;
	
	private String description;
	
	private Double quantity;
	private double price;
	
	public ProductDTO() {
		
	}
	public ProductDTO(String productTitle, String description, Double quantity, double price) {
		super();
		this.productTitle = productTitle;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}	
	
	

}
