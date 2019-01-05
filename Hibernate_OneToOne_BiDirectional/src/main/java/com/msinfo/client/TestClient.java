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

			EmployeeBO employee = getEmployee();
			int empId = (int) session.save(employee);

			session.getTransaction().commit();

			// Fetch record from table
			EmployeeBO employeeBO = session.get(EmployeeBO.class, 1);
			EmployeeAddressBO empAddress = employeeBO.getEmpAddress();
			System.out.println(empAddress);
			
			EmployeeAddressBO employeeAddressBO = session.get(EmployeeAddressBO.class, 1);
			System.out.println(employeeAddressBO.getEmployee());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static EmployeeBO getEmployee() {
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
		return emp;
	}
}
