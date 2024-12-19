package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Team;
public class getTeamAndPlayerDetailsTester {
	public static void main(String args[]) {
		
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			
			TeamDao dao = new TeamDaoImpl();			
			System.out.println("Enter team id search");			
			Team team=dao.getTeamAndPlayerDetails(sc.nextLong());
			System.out.println(team);
			System.out.println("All player - ");
			team.getPlayers().
			forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

