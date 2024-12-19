package com.sunbeam.dao;

import com.sunbeam.entities.Owner;

public interface OwnerDao {
	
	
	String addOwner(Long teamId,Owner newOwner);

}
