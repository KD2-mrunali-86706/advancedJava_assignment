package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
public class DisplayAllTeam {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			
			TeamDao userDao = new TeamDaoImpl();
			userDao.getAllTeam().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
