package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
public class UpdateMaxAgeTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter team name ,new age ");
			
			System.out.println(teamDao.updateAge(sc.next(), sc.nextInt()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
