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

			EmployeeBO emp = new EmployeeBO();
			emp.setEmployeeId(100);
			emp.setEmployeeName("Ashwin");
			emp.setEmployeeDob(new Date());

			EmployeeAddressBO address = new EmployeeAddressBO();
			address.setStreet("121 Main Street");
			address.setCity("Boston");
			address.setState("MA");
			address.setPincode(02150);

			emp.setEmpAddress(address);
			address.setEmployee(emp);

			int empId = (int) session.save(emp);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
