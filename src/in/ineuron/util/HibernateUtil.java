package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

public class HibernateUtil {

	private static SessionFactory factory = null;
	private static Session session = null;

	static {

		factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = factory.openSession();
		return session;
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

}
