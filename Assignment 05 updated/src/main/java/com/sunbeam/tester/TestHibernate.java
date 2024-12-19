package com.sunbeam.tester;
import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate  running  successfully!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
