package com.commerce.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="users")
public class User  extends BaseEntity{
	
	@Column(name = "first_name", length = 20) 
	private String firstName;
	@Column(name = "last_name", length = 20) 
	private String lastName;
	@Column(length = 25, unique = true) 
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	
	private LocalDate dob;

	@Enumerated(EnumType.STRING)
	@Column(length = 30) 
	private UserRole role;

	
	public User(){
		
	}

	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
	}
	
	
	
	
	
	

}
