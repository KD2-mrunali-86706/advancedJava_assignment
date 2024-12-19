package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Team;
//for asssociation
public class TeamAddNewTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter team details :"
					+" String name  "
					+" string abbreviation "
					+"string owner "
					+"int max_player  "
					+"double batting_avg "
					+"int wickets_taken "
							
							);
			Team team=new Team(sc.next(), sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(teamDao.addNewTeam(team));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
