package com.msinfo.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.msinfo.Utils.HibernateUtil;

public class HQLSelectTestClient {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = " select employeeId,employeeName from EmployeeBO";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] object : list) {
			Integer empId = (Integer) object[0];
			String empName = (String) object[1];
			System.out.println(empId + "," + empName);
		}
	}
}
