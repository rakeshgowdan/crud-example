package com.tyss.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emplyoee")
public class Employee {

	@Id
	private int  employeeId;
	private String name;
	private String address;
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + "]";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee(int employeeId, String name, String address) {
	
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}
	public Employee() {
		
	}
	
	
}
