package com.msinfo.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.msinfo.Entity.EmployeeBO;
import com.msinfo.Utils.HibernateUtil;

public class HQLHibernateTestClient {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		// query.list() example
		getAllEmployeeUsingList(session);

		// query.getResultList() example
		getEmployeeByEmpIdUsingPositionalParameter(session);

		// query.uniqueResult() example
		getEmployeeUniqueResultByEmployeeIdUsingPositionalParameter(session);

		//
		getEmployeeByEmpIdUsingNamedParameterList(session);
		// query.uniqueResult() with Named parameter example
		EmployeeBO uniqueResult4 = getEmployeeByEmpIdUsingNamedParameter(session);

		// query.list() example
		getEmployeeByEmpIdAndEmailUsingNamedParameters(session);

		// query.list() example
		getEmployeeNameUsingList(session);

		getEmployeeIdAndEmployeeNameUsingListObject(session);

	}

	private static void getEmployeeIdAndEmployeeNameUsingListObject(Session session) {
		String hql = " select employeeId,employeeName from EmployeeBO";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] object : list) {
			Integer empId = (Integer) object[0];
			String empName = (String) object[1];
			System.out.println(empId + "," + empName);
		}
	}

	private static void getEmployeeNameUsingList(Session session) {
		String hql = " select employeeName from EmployeeBO";
		Query<String> query = session.createQuery(hql);
		List<String> list = query.list();
		list.forEach(System.out::println);
	}

	private static void getEmployeeByEmpIdAndEmailUsingNamedParameters(Session session) {
		String hql = " from EmployeeBO where employeeId = :empId and employeeEmail = :email";
		int empId = 4;
		String emailId = "vikki@gmail.com";
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		query.setParameter("empId", empId);
		query.setParameter("email", emailId);
		List<EmployeeBO> resultList = query.getResultList();
		resultList.forEach(System.out::println);
	}

	private static EmployeeBO getEmployeeByEmpIdUsingNamedParameter(Session session) {
		String hql = " FROM EmployeeBO WHERE employeeId = :empId ";
		int empId = 4;
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		query.setParameter("empId", empId);
		EmployeeBO uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);
		return uniqueResult;
	}

	private static void getEmployeeByEmpIdUsingNamedParameterList(Session session) {
		String hql = " FROM EmployeeBO WHERE employeeId in (:ids ) ";
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		query.setParameterList("ids", new Integer[] {1,2,3});
		List<EmployeeBO> resultList = query.getResultList();
		resultList.forEach(System.out::println);
	}
	private static void getEmployeeUniqueResultByEmployeeIdUsingPositionalParameter(Session session) {
		String hql = " FROM EmployeeBO WHERE employeeId = ?1 ";
		int empId = 3;
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		query.setParameter(1, empId);
		EmployeeBO uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);
	}

	private static void getEmployeeByEmpIdUsingPositionalParameter(Session session) {
		String hql = " FROM EmployeeBO WHERE employeeId = ?1 ";
		int empId = 2;
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		query.setParameter(1, empId);
		List<EmployeeBO> list2 = query.getResultList();
		list2.forEach(System.out::println);
	}

	private static void getAllEmployeeUsingList(Session session) {
		String hql = " FROM EmployeeBO";
		Query createQuery = session.createQuery(hql);
		Query<EmployeeBO> query = session.createQuery(hql, EmployeeBO.class);
		List<EmployeeBO> list = query.list();
		list.forEach(System.out::println);
	}

}
