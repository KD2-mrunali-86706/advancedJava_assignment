package com.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dao.ProductDao;
import com.commerce.dto.ProductDTO;
import com.commerce.dto.UserDTO;
import com.commerce.entities.User;
import com.commerce.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	
	
	@PostMapping("/")
	public ResponseEntity<?> saveuser(@RequestBody UserDTO dto){
		try{
			return ResponseEntity.status(HttpStatus.CREATED).
					body(userService.addUser(dto));
		}
		catch(RuntimeException e) {
			System.out.println("not added data");
			e.printStackTrace();
			
			
			
		}
		
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addproduct(@RequestBody ProductDTO dto,@RequestParam Long userId){
		try{
			return ResponseEntity.status(HttpStatus.CREATED).
					body(userService.addProduct(dto,userId));
		}
		catch(RuntimeException e) {
			System.out.println("not added product");
			e.printStackTrace();
			
			
			
		}
		
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping
	public ResponseEntity<?> deleteProductDetails(@RequestParam() Long productId,@RequestParam Long userId)
	{
		System.out.println("in delete "+productId);
		try {
			//invoke service layer method
			return ResponseEntity.ok(
			userService.deleteproduct(userId, productId));
		} catch (RuntimeException e) {
			return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
					
					
		}
	}
	
	
	
	
	
	
	
	
	
	

}
