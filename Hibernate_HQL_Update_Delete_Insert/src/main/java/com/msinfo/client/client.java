package com.msinfo.client;

public class client {
	/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	// Check MySQL database version
	String sql = "select version()";
	String result = (String) session.createNativeQuery(sql).getSingleResult();
	System.out.println("MySql Database Version is:::");
	System.out.println(result);
	
	// Create table
	session.beginTransaction();
	Employee emp = getEmployee();
	session.save(emp);
	session.getTransaction().commit();
	
	// select table
	Employee employee = session.get(Employee.class, 1);
	System.out.println("Employee Details: " + employee	);
	
	// update table
	session.beginTransaction();
	employee.setEmployeeBirthPlace("Woburn");
	session.update(employee);
	session.getTransaction().commit();
	
	// update table
	session.beginTransaction();
	employee.setEmployeeBirthPlace("Chelsea");
	session.getTransaction().commit();
	
	// Delete employee 
	if(employee != null)
	{
	session.beginTransaction();
	session.delete(employee);
	session.getTransaction().commit();
	}
	
} catch (HibernateException e) {
	e.printStackTrace();
}*/
}
