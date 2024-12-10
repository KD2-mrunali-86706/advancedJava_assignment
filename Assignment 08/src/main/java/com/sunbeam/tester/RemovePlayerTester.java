package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
public class RemovePlayerTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			PlayerDao dao=new PlayerDaoImpl();
			System.out.println("Enter team id n player id");			
			System.out.println(dao.removePlayer(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
