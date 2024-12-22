package com.commerce.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"user", "product"})

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private double quantity;
	@Column(name = "totalamount", nullable = false)
	private Double amount;
	private String address;
	
	 private LocalDate orderDate; 
	 private String status;
	 
	public Order() {
		 this.orderDate = LocalDate.now();
	}
	public Order(User user, Product product, double quantity, double amount, String address) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
		this.address = address;
	}
	public Order(User user, Product product, double quantity, Double amount, String address, LocalDate orderDate,
			String status) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
		this.address = address;
		this.orderDate = orderDate;
		this.status = status;
	}
	public Order(double quantity, Double amount) {
		super();
		this.quantity = quantity;
		this.amount = amount;
	}
	
	
	
	
	

}
