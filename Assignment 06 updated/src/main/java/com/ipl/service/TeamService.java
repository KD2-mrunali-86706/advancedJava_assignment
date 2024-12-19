package com.ipl.service;

import java.util.List;

import com.ipl.entities.Team;

public interface TeamService {
	
	List<Team> getAllTeam();
	String addNewTeam(Team team);

}
