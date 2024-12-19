package com.sunbeam.dao;

import com.sunbeam.entities.Player;

public interface PlayerDao {
	String addNewPlayer(Long teamId,Player newplayer);
	
	String removePlayer(Long teamId,Long PlayerId);

}
