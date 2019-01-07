package com.msinfo.Entity;

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
	
	@OneToOne(
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			mappedBy="empAddress"
			)
	private EmployeeBO employee;
	
	
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

	
	public EmployeeBO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBO employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeAddressBO [employeeAddressId=" + employeeAddressId + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", employee=" + employee + "]";
	}

	

	
}


