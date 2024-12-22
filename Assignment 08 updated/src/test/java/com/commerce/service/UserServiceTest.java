package com.commerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.commerce.entities.Order;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired 
	private UserService userService;
	
	@Test
	void testPlaceOrder_InvalidAmount() {
       
        Order order = new Order( 5,-2000.0);

       
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.placeOrder(order);
        });

        assertEquals("Total amount must be greater than zero", exception.getMessage());
    }

}
