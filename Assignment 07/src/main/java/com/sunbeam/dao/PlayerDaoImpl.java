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
				//=> category : persistent
				//5. Establish bi dir association between entities
				/*
				 * add a blog post ref in the List
				 * set category ref to the post
				 */
				team.addPlayer(newplayer);
				session.persist(newplayer);	//required since - no cascading still!!!!			
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

}
