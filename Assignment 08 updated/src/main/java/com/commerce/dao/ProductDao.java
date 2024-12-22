package com.commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.entities.Product;

public interface ProductDao extends JpaRepository<Product,Long> {

}
