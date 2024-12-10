package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
public class DisplayTeamByAvgAndAge {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter team age and  batting average ");			

			
			teamDao.getSelectedTeam(sc.nextInt(), sc.nextDouble()).forEach(System.out::println);;
			
			//input age=18 average=10
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
