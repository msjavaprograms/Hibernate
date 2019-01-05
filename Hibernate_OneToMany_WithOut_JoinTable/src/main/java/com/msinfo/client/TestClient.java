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
			
			
			EmployeeBO employeeBO = session.get(EmployeeBO.class, 1);
			System.out.println(employeeBO);
			
			if(employeeBO != null)
			{
				employeeBO.getEmployerAddress().forEach(System.out::println);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static EmployeeBO getEmployee() {
		EmployeeBO emp = new EmployeeBO();
		emp.setEmployeeId(100);
		emp.setEmployeeName("Ashwin");
		emp.setEmployeeDob(new Date());

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
		
		emp.getEmployerAddress().add(address1);
		emp.getEmployerAddress().add(address2);
		
		address1.setEmployee(emp);
		address2.setEmployee(emp);
		
		return emp;
	}
}
