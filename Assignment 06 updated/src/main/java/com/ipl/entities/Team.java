package com.ipl.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
//@ToString(callSuper=true,exclude="players")
@NoArgsConstructor
@Entity

public class Team extends BaseEntity {
	@Column(length=100,unique=true)
	private String name;


	@Column(length=10,unique=true)
	private String abbreviation ;




	@Column(name="max_player_age")
	private int maxPlayerAge;
	 
	@Column(name="batting_avg")
	private double battingAvg;

	@Column(name="wickets_taken")
	private int wicketsTaken;

	public Team(String name, String abbreviation, int maxPlayerAge, double battingAvg, int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	

	
}
