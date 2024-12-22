package com.commerce.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dto.OrderReqDTO;
import com.commerce.dto.OrderResponseDTO;
import com.commerce.dto.ProductDTO;
import com.commerce.entities.Order;
import com.commerce.service.UserService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getProduct() {
		System.out.println("get all");
		List<ProductDTO> product = 
				userService.getallproduct();
		if (product.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(product);
	}

	@PostMapping("/place")
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderReqDTO orderRequest) {
        OrderResponseDTO orderResponse = userService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/orderplaced")
    public ResponseEntity<List<Order>> getOrdersWithinDateRange(
            @RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        
        List<Order> orders = userService.getOrdersWithinDateRange(startDate, endDate);
        return ResponseEntity.ok(orders);
    }
	
}
	
	
	


