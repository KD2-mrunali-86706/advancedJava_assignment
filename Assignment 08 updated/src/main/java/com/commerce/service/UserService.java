package com.commerce.service;

import java.time.LocalDate;
import java.util.List;

import com.commerce.dto.OrderReqDTO;
import com.commerce.dto.OrderResponseDTO;
import com.commerce.dto.ProductDTO;
import com.commerce.dto.UserDTO;
import com.commerce.entities.Order;
import com.commerce.entities.Product;


public interface UserService  {
	String addUser(UserDTO dto);
	Product addProduct(ProductDTO dto,Long userId);
	String deleteproduct(Long userId,Long productId);
	
	List<ProductDTO> getallproduct();
	
OrderResponseDTO placeOrder(OrderReqDTO dto);


 List<Order> getOrdersWithinDateRange(LocalDate startDate, LocalDate endDate);
	
	/*
	 * to check integration testing
	 * */
Order placeOrder(Order order);
	
	
	

}
