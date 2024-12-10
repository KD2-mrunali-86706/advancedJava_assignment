package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Team;

public interface TeamDao {
	public String signUpTeam(Team t);

	public List<Team> getAllTeam();
	
	
	List<Team> getSelectedTeam(int maxPlayerAge, double battingAvg);
	
	List<Team> getOwnerNameAndAbbrevation(int maxPlayerAge, double battingAvg);
	
	
	
	String updateAge(String name,int newmaxPlayerAge);
	
	String deleteTeamById(Long teamId);

}
