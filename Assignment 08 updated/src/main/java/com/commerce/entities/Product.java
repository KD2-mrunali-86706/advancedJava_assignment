package com.commerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product  extends BaseEntity{
	@Column(length=20)
	private  String productTitle;
	@Column(length=20)
	private String description;
	@Column(name="quantity")
	private Double quantity;
	
    private double price;
    

    

	public Product(String productTitle, String description, Double quantity, double price) {
		super();
		this.productTitle = productTitle;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}



	public Product() {
		
	}	

}
