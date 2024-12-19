package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.*;

@Getter
@Setter
@ToString(callSuper=true,exclude="")
@NoArgsConstructor
@Entity
public class Owner extends BaseEntity {
	
@Column(name="name" ,length=20)	
private String name;
@Column(name="email_id" ,length=20)	
private String email;
@Column(name="comapny_name" ,length=20)	
private String companyName;

@OneToOne //default fetch type : EAGER
@JoinColumn(name="team_id")
private Team team;





public Owner(String name, String email, String companyName) {
	super();
	this.name = name;
	this.email = email;
	this.companyName = companyName;
}


	

}


