package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@ToString(callSuper=true,exclude="players")
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



//we need to add orphanremoval to delete from databses

@OneToMany(mappedBy="teamPlayer",cascade=CascadeType.ALL ,orphanRemoval = true,fetch = FetchType.EAGER)
private List<Player> players=new ArrayList<>();


















public Team(String name, String abbreviation, int maxPlayerAge, double battingAvg, int wicketsTaken) {
	super();
	this.name = name;
	this.abbreviation = abbreviation;
	
	this.maxPlayerAge = maxPlayerAge;
	this.battingAvg = battingAvg;
	this.wicketsTaken = wicketsTaken;
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



