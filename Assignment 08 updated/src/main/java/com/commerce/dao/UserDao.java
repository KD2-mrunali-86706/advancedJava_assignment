package com.commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.entities.User;

public interface UserDao  extends JpaRepository<User,Long>{

}
