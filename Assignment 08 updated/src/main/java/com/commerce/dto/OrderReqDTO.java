package com.commerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderReqDTO {
	
	Long customerId ;
	Long productId  ;
	double quantity;
	public OrderReqDTO(Long customerId, Long productId, double quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
	


}
