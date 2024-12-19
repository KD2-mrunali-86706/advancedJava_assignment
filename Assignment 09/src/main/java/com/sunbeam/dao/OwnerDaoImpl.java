package com.sunbeam.dao;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Owner;
import com.sunbeam.entities.Team;

public class OwnerDaoImpl implements OwnerDao {

	@Override
	public String addOwner(Long teamId, Owner newOwner) {
      String msg="owner added !";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			Team t=session.get(Team.class,teamId);
			newOwner.setTeam(t);
			
			session.persist(newOwner);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		return msg;
	}
	}


