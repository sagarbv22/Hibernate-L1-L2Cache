package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			Employee e1 = session.get(Employee.class, 1);
			System.out.println("1. " + e1);// from DB keeps record in L2&L1

			Employee e2 = session.get(Employee.class, 1);
			System.out.println("2. " + e2);// from L1 cache

			session.evict(e1);// removed from L1 cache

			Employee e3 = session.get(Employee.class, 1);
			System.out.println("3. " + e3);// from L2

			Employee e4 = session.get(Employee.class, 2);
			System.out.println("4. " + e4);// from DB keeps record in L2&L1

			session.clear();// Removed all objects from L1 cache

			Thread.sleep(20000);//20secs(idleTimeout is expired so object removed from L2-cache)

			Employee e5 = session.get(Employee.class, 2);
			System.out.println("5. " + e5);// from DB keeps record in L2&L1

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 finally {

				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			}
	}

}
