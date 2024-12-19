package com.ipl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.entities.Team;

public interface TeamDao  extends JpaRepository<Team, Long>{

}
