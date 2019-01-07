package com.msinfo.client;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.msinfo.Utils.HibernateUtil;

public class HQLUpdateTestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			int employeeId = 1;
			String hql = " update EmployeeBO set employeeEmail=:email where employeeId=:empId";
			Query query = session.createQuery(hql);
			query.setParameter("email", "saravanan@gmail.com");
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
