package com.msinfo.client;

import java.util.Date;

import org.hibernate.Session;

import com.msinfo.Entity.EmployeeAddressBO;
import com.msinfo.Entity.EmployeeBO;
import com.msinfo.Utils.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			EmployeeBO emp1 = new EmployeeBO();
			emp1.setEmployeeId(100);
			emp1.setEmployeeName("Ashwin");
			emp1.setEmployeeDob(new Date());
			
			EmployeeBO emp2 = new EmployeeBO();
			emp2.setEmployeeId(101);
			emp2.setEmployeeName("Muthu");
			emp2.setEmployeeDob(new Date());

			EmployeeAddressBO address1 = new EmployeeAddressBO();
			address1.setStreet("121 Main Street");
			address1.setCity("Boston");
			address1.setState("MA");
			address1.setPincode(02150);

			EmployeeAddressBO address2 = new EmployeeAddressBO();
			address2.setStreet("122 Main Street");
			address2.setCity("cambridge");
			address2.setState("MA");
			address2.setPincode(02151);
			
			EmployeeAddressBO address3 = new EmployeeAddressBO();
			address3.setStreet("123 Main Street");
			address3.setCity("Stoneham");
			address3.setState("MA");
			address3.setPincode(02153);
			
			
			emp1.getEmployerAddress().add(address1);
			emp2.getEmployerAddress().add(address2);
			emp2.getEmployerAddress().add(address3);
			emp1.getEmployerAddress().add(address3);
			
			address1.getEmployee().add(emp1);
			address2.getEmployee().add(emp2);
			address2.getEmployee().add(emp2);
			address3.getEmployee().add(emp1);
			
			// Create table and insert value
			session.beginTransaction();

			int empId1 = (int) session.save(emp1);
			int empId2 = (int) session.save(emp2);
			
			session.getTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
