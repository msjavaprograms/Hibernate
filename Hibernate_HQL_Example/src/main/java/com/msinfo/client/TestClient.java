package com.msinfo.client;

import java.util.Date;

import org.hibernate.Session;

import com.msinfo.Entity.EmployeeAddressBO;
import com.msinfo.Entity.EmployeeBO;
import com.msinfo.Utils.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Create table and insert value
			session.beginTransaction();

			EmployeeBO emp1 = new EmployeeBO();
			emp1.setEmployeeName("Ashwin");
			emp1.setEmployeeDob(new Date());
			emp1.setEmployeeFatherName("Muthu");
			emp1.setEmployeeEmail("Muthu@gmail.com");
			
			EmployeeBO emp2 = new EmployeeBO();
			emp2.setEmployeeName("Raj");
			emp2.setEmployeeDob(new Date());
			emp2.setEmployeeFatherName("Sakkarai");
			emp2.setEmployeeEmail("raj@gmail.com");
			
			EmployeeBO emp3 = new EmployeeBO();
			emp3.setEmployeeName("Agnisha");
			emp3.setEmployeeDob(new Date());
			emp3.setEmployeeFatherName("Sha");
			emp3.setEmployeeEmail("sha@gmail.com");
			
			EmployeeBO emp4 = new EmployeeBO();
			emp4.setEmployeeName("Vikki");
			emp4.setEmployeeDob(new Date());
			emp4.setEmployeeFatherName("ragavan");
			emp4.setEmployeeEmail("vikki@gmail.com");

			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
