package com.commerce.dto;

import com.commerce.entities.Product;
import com.commerce.entities.User;
import com.commerce.entities.UserRole;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class OrderResponseDTO {
     private Long customerId;
	
	
	  private Long productId;
	 private Long orderId;
	 private String productName;
	 private double quantity;
	 private double totalAmount;
	 private String address;

	 private UserRole role;


	public OrderResponseDTO() {
		
	}


	public OrderResponseDTO(Long customerId, Long productId, Long orderId, String productName, double quantity,
			double totalAmount, String address, UserRole role) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.address = address;
		this.role = role;
	}



	


	





	
	
	
	

}
