package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Team extends BaseEntity {


@Column(length=100,unique=true)
private String name;


@Column(length=10,unique=true)
private String abbreviation ;


@Column(length=20,nullable=false)
private String owner;


@Column(name="max_player_age")
private int maxPlayerAge;
 
@Column(name="batting_avg")
private double battingAvg;

@Column(name="wickets_taken")
private int wicketsTaken;

@OneToMany(mappedBy="teamPlayer")
private List<Player> players=new ArrayList<>();


















public Team(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg, int wicketsTaken) {
	super();
	this.name = name;
	this.abbreviation = abbreviation;
	this.owner = owner;
	this.maxPlayerAge = maxPlayerAge;
	this.battingAvg = battingAvg;
	this.wicketsTaken = wicketsTaken;
}






public Team( String owner,String abbreviation) {
	
	
	this.owner = owner;
	this.abbreviation = abbreviation;
}



//helper method to add child ref to biderectional association
public void addPlayer(Player player) {
	this.players.add(player);
	player.setTeamPlayer(this);
}

//add helper  to remove
public void removeplayer(Player player)
{
	this.players.remove(player);
	player.setTeamPlayer(null);	

}



}



