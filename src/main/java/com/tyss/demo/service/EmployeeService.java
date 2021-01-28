package com.tyss.demo.service;

import java.util.List;

import com.tyss.demo.dto.Employee;

public interface EmployeeService {

	public List<Employee> listOfEmployee();
	public boolean addUser(String name,String address);
	public Employee fetchUserById(int id);
	public boolean updateUser(Employee employee);
	public boolean deleteUserbyId(int id);
}
