package com.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ipl.entities.Team;
import com.ipl.service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
	
	
	
	public TeamController() {
		System.out.println("team controller");
	}


	@Autowired
	private TeamService teamService;
	
	
	@GetMapping
	public ResponseEntity<?> getCategories() {
		System.out.println("get all");
		List<Team> team = teamService.getAllTeam();
		if (team.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(team);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<?> addTeam(@RequestBody Team team){
		System.out.println("Inside add team ");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addNewTeam(team));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
