package com.sunbeam.dao;

import com.sunbeam.entities.Team;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class TeamDaoImpl implements TeamDao {

	@Override
	public String signUpTeam(Team t) {
		
		String msg="team registration failed!!!!!!!!!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			Serializable teamId = session.save(t);
			//=> success
			tx.commit();
			msg="team signed up ! , ID "+teamId;
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return msg;
	
	}

}
