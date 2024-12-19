package com.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipl.dao.TeamDao;
import com.ipl.entities.Team;
@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDao teamDao;
	private Team save;

	@Override
	public List<Team> getAllTeam() {
		
		return teamDao.findAll();
	}

	@Override
	public String addNewTeam(Team team) {
		Team teamAdd = teamDao.save(team);
		return "Added new Category with ID="+teamAdd.getId();
	}

	
	

}
