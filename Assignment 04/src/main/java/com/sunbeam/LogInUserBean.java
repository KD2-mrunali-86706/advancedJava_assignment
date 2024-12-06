package com.sunbeam;

import dao.UserDao;
import dao.UserDaoImpl;
import entities.User;

public class LogInUserBean {
	String email;
	String passwd;
	int count;
	private User user;
	public LogInUserBean() {
		
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void logInUser() {
		try (UserDao userDao=new UserDaoImpl()){
			User user=userDao.findByEmail(email);
			if(user!=null && user.getPassword().equals(passwd))
			{
				this.user=user;
			}
			else {
				this.user=null;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
