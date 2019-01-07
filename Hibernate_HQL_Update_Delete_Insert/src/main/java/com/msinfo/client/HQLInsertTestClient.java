package com.msinfo.client;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.msinfo.Utils.HibernateUtil;

public class HQLInsertTestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			int employeeId = 4;
			String hql = "INSERT INTO Employee(employeeId,employeeName,employeeDob,employeeFatherName,employeeEmail)"
					+ "select employee_seq.nextval,employeeId,employeeName,employeeDob,employeeFatherName,employeeEmail "
					+ "from employeeDetail";
			Query query = session.createQuery(hql);
			query.setParameter("empId", employeeId);

			session.beginTransaction();
			int executeUpdate = query.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println(executeUpdate);
				System.out.println("Update successfully");
			}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
