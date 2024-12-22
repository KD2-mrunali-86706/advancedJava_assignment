package com.commerce.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.entities.Order;

public interface OrderDao extends JpaRepository<Order,Long>{
	
	 List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

}
