package com.msinfo.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="EMPLOYEE")
@DynamicUpdate
public class EmployeeBO {

	@Id
	@Column(name="EMPLOYEE_ID",length=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer employeeId;
	
	@Column(name="NAME",length=20,nullable=false)
	String employeeName;
	
	@Column(name="DOB",nullable=true)
	Date employeeDob;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ADDR_ID")
	private EmployeeAddressBO empAddress;
	
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

	public EmployeeAddressBO getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(EmployeeAddressBO empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "EmployeeBO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDob="
				+ employeeDob +  ", empAddress=" + empAddress + "]";
	}

	
	
}
