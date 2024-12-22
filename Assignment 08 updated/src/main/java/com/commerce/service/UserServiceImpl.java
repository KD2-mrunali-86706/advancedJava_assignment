package com.commerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commerce.dao.OrderDao;
import com.commerce.dao.ProductDao;
import com.commerce.dao.UserDao;
import com.commerce.dto.OrderReqDTO;
import com.commerce.dto.OrderResponseDTO;
import com.commerce.dto.ProductDTO;
import com.commerce.dto.UserDTO;
import com.commerce.entities.Order;
import com.commerce.entities.Product;
import com.commerce.entities.User;
import com.commerce.entities.UserRole;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
    @Autowired
    private ProductDao productDao;
	
    @Autowired
	private ModelMapper modelMapper;
    
    @Autowired 
    private OrderDao orderDao;
	
   
	
		
		
		
	

	@Override
	public String addUser(UserDTO dto) {
		
		User user=modelMapper.map(dto,User.class);
		
		userDao.save(user);
		
		return "user added successfuly";
	}








	@Override
	public Product addProduct(ProductDTO dto, Long userId) {
		
        User user = userDao.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        
        if (!UserRole.ADMIN.equals(user.getRole())) {
            throw new IllegalArgumentException("Only Admins can add products.");
        }

       
        Product product = new Product(
           dto.getProductTitle(),
           dto.getDescription(),
           dto.getQuantity(),
           dto.getPrice()
           
            
        );

       
        return productDao.save(product);
	}








	@Override
	public String deleteproduct(Long userId,Long productId) {

        User user = userDao.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if(!UserRole.ADMIN.equals(user.getRole())){
        	throw new IllegalArgumentException("Only Admins can delete products.");
        }
        
        productDao.deleteById(productId);
        
		return "product deleted successfully";

	}
	
	
	





/*
 * 
 * */


	@Override
	public List<ProductDTO> getallproduct() {
		
	        return 	productDao.findAll().stream().map(product ->modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
	        	
	        	
	        	
	        }













/*
 * 4.4. Customer should be able to place order for a specific product.
i/p - customer id , product id  , quantity
o/p - in case of success - order should be placed n customer should be able to see the order details
including total order amount.
 */

	@Override
	public OrderResponseDTO placeOrder(OrderReqDTO dto) {
		
		User user=userDao.findById(dto.getCustomerId()).orElseThrow();
		if(!UserRole.CUSTOMER.equals(user.getRole()))
		{
			throw new IllegalArgumentException("Only customer can place order.");
		}
		Product  product=productDao.findById(dto.getProductId()).orElseThrow();
		if (dto.getQuantity() > product.getQuantity()) {
		    System.out.println("Quantity is insufficient");
		    return null; 
		}
		
		double totalAmount=product.getPrice()*dto.getQuantity();
		
		Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setAddress("ramnagar");
        order.setQuantity(dto.getQuantity());
        order.setAmount(totalAmount);
        order.setStatus("Pending"); 
        
		
        Order savedOrder = orderDao.save(order);
        OrderResponseDTO orderResponse = new OrderResponseDTO();
        orderResponse.setOrderId(savedOrder.getId());
       
        orderResponse.setProductId(product.getId());
       orderResponse.setCustomerId(user.getId());
      
       orderResponse.setAddress(order.getAddress());
       orderResponse.setQuantity(dto.getQuantity());
        orderResponse.setTotalAmount(totalAmount);
		
		return  orderResponse;
	}






/*
 * 5. Admin should be able to check all the orders placed within a specific period
i/p - start date n end date

 */

	@Override
	public List<Order> getOrdersWithinDateRange(LocalDate startDate, LocalDate endDate) {
		 if (startDate.isAfter(endDate)) {
	            throw new IllegalArgumentException("Start date cannot be the  after end date");
	        }
	        return orderDao.findByOrderDateBetween(startDate, endDate);
	}








	@Override
	public Order placeOrder(Order order) {
		 if (order.getAmount() <= 0) {
	            throw new IllegalArgumentException("Total amount must be greater than zero");
	        }
	        order.setStatus("Pending");
	        return orderDao.save(order);
	    }
	}








	

	








	








	
	
	   
	








	















	






	







	


