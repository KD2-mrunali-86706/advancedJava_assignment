package com.sunbeam;

import java.sql.Date;

import dao.UserDao;
import dao.UserDaoImpl;
import entities.User;



public class UserBean {
	
	
	String firstName;
	 String lastName;
	 String email;
	 String password;
	 String birth;
	 int count;
	

	public UserBean() {
		
	}


	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void registerUser() {
		try(UserDao userDao=new UserDaoImpl())
		{
			Date dob=Date.valueOf(birth);
			User user=new User(0,firstName,lastName,email,password,dob,0,"voter");
			count=userDao.save(user);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
	
	
}
