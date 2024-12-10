package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
public class getTeamOwnerAbbrTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter team age and  batting average ");					
//			userDao.getSelectedUsersByRole(UserRole.valueOf(sc.next()
//					.toUpperCase()))
//					.forEach(user -> System.out.println(user.getFirstName()
//							+" "+user.getLastName()+" "+user.getDob()));
			
			teamDao.getOwnerNameAndAbbrevation(sc.nextInt(), sc.nextDouble()).forEach(team->System.out.println(team.getOwner()+" "+team.getAbbreviation()));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
