package com.msinfo.client;

import java.util.Date;

import org.hibernate.Session;

import com.msinfo.Entity.EmployeeBO;
import com.msinfo.Utils.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Create Record using Hibernate - save method
			session.beginTransaction();
			EmployeeBO emp1 = getEmployee1();
			session.save(emp1);
			session.getTransaction().commit();

			// Create Record using Hibernate - persist method
			session.beginTransaction();
			EmployeeBO emp2 = getEmployee2();
			session.persist(emp2);
			session.getTransaction().commit();

			// Create Record using Hibernate - persist method
			session.beginTransaction();
			EmployeeBO emp3 = getEmployee3();
			session.save(emp3);
			session.getTransaction().commit();

			// Read record using Hibernate - get method
			EmployeeBO employee1 = session.get(EmployeeBO.class, 1);
			System.out.println("Employee one Details: " + employee1);

			// Read record using Hibernate - load method
			EmployeeBO employee2 = session.load(EmployeeBO.class, 2);
			System.out.println("Employee two Details: " + employee2);

			// update table using Hibernate - update method
			session.beginTransaction();
			employee1.setEmployeeEmail("Achu@gmail.com");
			session.update(employee1);
			session.getTransaction().commit();

			// update table using Hibernate - saveOrUpdate method
			session.beginTransaction();
			employee2.setEmployeeEmail("Musa@gmail.com");
			session.saveOrUpdate(employee2);
			session.getTransaction().commit();

			// update table using Hibernate - saveOrUpdate method
			session.beginTransaction();
			employee2.setEmployeeName("MuthuSaran");
			session.merge(employee2);
			session.getTransaction().commit();

			// Delete employee
			if (emp3 != null) {
				session.beginTransaction();
				session.delete(emp3);
				session.getTransaction().commit();
			}

			// Read record using Hibernate - get method
			EmployeeBO empl1 = session.get(EmployeeBO.class, 1);
			System.out.println("Employee one Details: " + empl1);

			// Read record using Hibernate - load method
			EmployeeBO empl2 = session.load(EmployeeBO.class, 2);
			System.out.println("Employee two Details: " + empl2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static EmployeeBO getEmployee1() {
		EmployeeBO emp = new EmployeeBO();
		emp.setEmployeeId(100);
		emp.setEmployeeName("Ashwin");
		emp.setEmployeeDob(new Date());
		emp.setEmployeeEmail("Ashwin@gmail.com");

		return emp;
	}

	private static EmployeeBO getEmployee2() {
		EmployeeBO emp = new EmployeeBO();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Muthu");
		emp.setEmployeeDob(new Date());
		emp.setEmployeeEmail("Saran@gmail.com");

		return emp;
	}

	private static EmployeeBO getEmployee3() {
		EmployeeBO emp = new EmployeeBO();
		emp.setEmployeeId(103);
		emp.setEmployeeName("Agnisha");
		emp.setEmployeeDob(new Date());
		emp.setEmployeeEmail("Agnisha@gmail.com");
		return emp;
	}
}
