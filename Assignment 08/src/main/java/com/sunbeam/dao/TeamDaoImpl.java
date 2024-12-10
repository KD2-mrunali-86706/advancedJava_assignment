package com.sunbeam.dao;


import com.sunbeam.entities.Team;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public List<Team> getAllTeam() {
		
		String jpql = "select t from Team t";
		List<Team> teams = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return teams;
	}

	@Override
	public List<Team> getSelectedTeam(int maxPlayerAge, double battingAvg) {
		List<Team> teams = null;                   //t.maxplayerage is property 
		String jpql = "select t from Team t where t.maxPlayerAge<:mpa and t.battingAvg > :ba";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("mpa", maxPlayerAge).setParameter("ba", battingAvg)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return teams;
		
	}

	@Override
	public List<Team> getOwnerNameAndAbbrevation(int maxPlayerAge, double battingAvg) {
		
		List<Team> teams = null;
		String jpql = "select new com.sunbeam.entities.Team(owner,abbreviation)  from Team t where t.maxPlayerAge<:mpa and t.battingAvg>:ba";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("mpa", maxPlayerAge).setParameter("ba",battingAvg ).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return teams;
	}

	@Override
	public String updateAge(String name, int newmaxPlayerAge) {
		Team team=null;
		String msg = "maxage updation failed !!!!!!";
		String jpql = "select t from Team t where t.name=:n ";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			team=session.createQuery(jpql, Team.class)
					.setParameter("n",name)
					.getSingleResult();
			
					team.setMaxPlayerAge(newmaxPlayerAge);//user -persistent
			//session.evict(team);
			//team - detached
			tx.commit();
			msg="maxage changed !";
					
		} catch (RuntimeException e) {
			
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public String deleteTeamById(Long teamId) {
		String msg="Deletion failed!!!!!!";
		Team team=null;
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			team=session.get(Team.class, teamId);
			if(team != null)
			{
				
				session.delete(team);
				msg="deleted team details !";
			}
			tx.commit();
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
	
		return msg;
	}

	
	
	
	//add new team for 
	
	@Override
	public String addNewTeam(Team team) {
		String msg="adding team failed!!!";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			session.persist(team);
			tx.commit();
			msg="added new team with id="+team.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return msg;
	}

	
	
	//to show the player of particular existing team
	@Override
	public Team getTeamAndPlayerDetails(Long teamId) {
		Team team=null;
		String jpql="select t from Team t left join fetch t.players where t.id=:i";
Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			team=session.createQuery(jpql, Team.class)
					.setParameter("i", teamId)
					.getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return team;
	}

	
}
