
package com.javarnd.pns.db;

import java.util.function.Function;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static <T> T runInTransaction(Function<Session, T> function) {
		Transaction tx = null;
		try (Session session = HibernateUtil.openSession()) {
			tx = session.beginTransaction();
			final T result = function.apply(session);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] argss) {
		openSession();
		System.out.println("connection open");
	}
}