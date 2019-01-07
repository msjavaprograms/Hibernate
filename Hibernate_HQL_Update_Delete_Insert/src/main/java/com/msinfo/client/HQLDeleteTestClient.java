package com.msinfo.client;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.msinfo.Utils.HibernateUtil;

public class HQLDeleteTestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			int employeeId = 4;
			String hql = " Delete from EmployeeBO where employeeId=:empId";
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
