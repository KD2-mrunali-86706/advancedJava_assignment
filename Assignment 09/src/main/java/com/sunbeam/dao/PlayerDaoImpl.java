package com.sunbeam.dao;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Player;
import com.sunbeam.entities.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Long teamId, Player newplayer) {
		String msg="adding player failed!!!!!";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//3. get category from it's id
			Team team=session.get(Team.class, teamId);
			//4 . null checking
			if(team != null)
			{
				
				team.addPlayer(newplayer);
				//session.persist(newplayer);	//required since - no cascading still if we add cascade then not need to write this!!!!			
			}	
		
			tx.commit();
			msg="added new player , id="+newplayer.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return msg;
	}

	
	//to remove the player from team we need helper then we called pojoteam class helper method player
	
	@Override
	public String removePlayer(Long teamId, Long PlayerId) {
		
		String msg="removing player failed";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			Team team=session.get(Team.class, teamId);
			Player player=session.get(Player.class, PlayerId);
			if(team !=null && player!=null) {
				team.removeplayer(player);
				msg="player removed";
				tx.commit();

			}
						
		}
		catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
