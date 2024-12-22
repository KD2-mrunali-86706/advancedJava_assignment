package com.commerce.dto;
import java.time.LocalDate;

import com.commerce.entities.UserRole;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO  extends BaseDTO{
	
	private String firstName;
	
	
	private String lastName;
private String email;
	
	private String password;
	private LocalDate dob;
    private UserRole role;

}
