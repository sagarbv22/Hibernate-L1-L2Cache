package in.ineuron.test;

import java.io.IOException;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		boolean flag = false;
		Integer row = 0;
		Transaction transaction = null;
		Employee employee = null;

		try {

			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				employee = new Employee();
				employee.setEname("Soma");
				employee.setDob(LocalDate.of(2000, 06, 9));
				employee.setEcompany("Deloite");
				employee.setDoj(LocalDate.of(2023, 04, 27));
				employee.setEcity("Blr");

				row = (Integer) session.save(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Success");
			} else {
				transaction.rollback();
				System.out.println("Failed");
			}

		}

	}

}
