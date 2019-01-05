package com.msinfo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_ADDRESS")
public class EmployeeAddressBO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ADDR_ID")
	private Integer employeeAddressId;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PINCODE")
	private Integer pincode;
	
	@ManyToMany(mappedBy="employerAddress") 
	private Set<EmployeeBO> employee = new HashSet<EmployeeBO>() ;

	public Integer getEmployeeAddressId() {
		return employeeAddressId;
	}

	public void setEmployeeAddressId(Integer employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Set<EmployeeBO> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeBO> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeAddressBO [employeeAddressId=" + employeeAddressId + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", employee=" + employee + "]";
	}

	
	
}


