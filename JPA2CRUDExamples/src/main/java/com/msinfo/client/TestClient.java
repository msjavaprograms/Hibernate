package com.msinfo.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.msinfo.Entity.EmployeeBO;

public class TestClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExamples");
		EmployeeBO employee = getEmployee1();

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		/* Persist entity */
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();

		/* Retrieve entity */
		employee = em.find(EmployeeBO.class, 1);
		System.out.println(employee);

		/* Update entity */
		em.getTransaction().begin();
		employee.setEmployeeName("Achu");
		System.out.println("Employee after updation :- " + employee);
		em.getTransaction().commit();

		/* Remove entity */
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();

		/* Check whether enittiy is removed or not */
		employee = em.find(EmployeeBO.class, 1);
		System.out.println("Employee after removal :- " + employee);

	}

	private static EmployeeBO getEmployee1() {
		EmployeeBO emp = new EmployeeBO();
		emp.setEmployeeId(100);
		emp.setEmployeeName("Ashwin");
		emp.setEmployeeDob(new Date());
		emp.setEmployeeEmail("Ashwin@gmail.com");

		return emp;
	}

}
