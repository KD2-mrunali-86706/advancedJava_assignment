package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.entities.Player;
public class AddNewPlayerTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			
			PlayerDao playerDao=new PlayerDaoImpl();
			System.out.println("Enter team id");
			Long teamId=sc.nextLong();
			System.out.println("Enter player details :"+
		
			" string firstName "+
			 " string lastName"+
			" Date dob"
			+" double battingAvg "
			+" int wicketsTaken "
					);
			
			Player p=new Player(sc.next(), sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			System.out.println(playerDao.addNewPlayer(teamId, p));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}


