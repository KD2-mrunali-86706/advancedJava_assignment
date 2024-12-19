package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.OwnerDao;
import com.sunbeam.dao.OwnerDaoImpl;
import com.sunbeam.entities.Owner;
public class AddOwnerTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); 
				Scanner sc = new Scanner(System.in)) {
			OwnerDao dao=new OwnerDaoImpl();
			System.out.println("Enter team id");
			Long userId = sc.nextLong();
			System.out.println(
					"Enter adr details - name, Stringemail, String companyname");
		Owner owner = new Owner(sc.next(), sc.next(), sc.next());
			System.out.println(dao.addOwner(userId, owner));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
