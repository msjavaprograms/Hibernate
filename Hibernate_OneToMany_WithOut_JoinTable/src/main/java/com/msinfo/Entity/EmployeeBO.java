package com.msinfo.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
	
	@OneToMany(
				cascade=CascadeType.ALL,
				mappedBy="employee",
				fetch=FetchType.LAZY
			  )
	private Set<EmployeeAddressBO> employerAddress = new HashSet<EmployeeAddressBO>();
	
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

	public Set<EmployeeAddressBO> getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(Set<EmployeeAddressBO> employerAddress) {
		this.employerAddress = employerAddress;
	}

	@Override
	public String toString() {
		return "EmployeeBO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDob="
				+ employeeDob + ", employerAddress=" + employerAddress + "]";
	}

	
}
