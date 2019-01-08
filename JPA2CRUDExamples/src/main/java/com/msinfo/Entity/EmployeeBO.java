package com.msinfo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYEE")
public class EmployeeBO {

	@Id
	@Column(name="EMPLOYEE_ID",length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer employeeId;
	
	@Column(name="NAME",length=20,nullable=false)
	String employeeName;
	
	@Column(name="DOB",nullable=true)
	Date employeeDob;
	
	@Column(name="EMPLOYEE_EMAIL",nullable=false)
	private String employeeEmail;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(Date employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Override
	public String toString() {
		return "EmployeeBO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDob="
				+ employeeDob + ", employeeEmail=" + employeeEmail + "]";
	}

	
	
}
