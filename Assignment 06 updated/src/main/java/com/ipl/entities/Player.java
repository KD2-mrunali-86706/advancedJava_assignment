package com.ipl.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
public class Player extends BaseEntity {
	@Column(name="first_name",length=20)
	private String firstName;
	
	
	@Column(name="last_name",length=20)
	private String lastName;
	
	private LocalDate dob;
	
	
	@Column(name="batting_avg")
	private double battingAvg;
	
	
	
	@Column(name="wickets_taken")
	private int wicketsTaken;
	
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team teamPlayer;


	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}


}
