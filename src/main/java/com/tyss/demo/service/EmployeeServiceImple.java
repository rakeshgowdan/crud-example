package com.tyss.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.demo.dao.EmployeeDao;
import com.tyss.demo.dto.Employee;

@Service
public class EmployeeServiceImple  implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao; 
	
	public List<Employee> listOfEmployee() {
		return employeeDao.listOfEmployee();
	}

	public boolean addUser(String name, String address) {
		return employeeDao.addUser(name,address);
	}

	public Employee fetchUserById(int id) {
		return employeeDao.fetchUserById(id);
	}

	public boolean updateUser(Employee employee) {
		return employeeDao.updateUser(employee);
	}

	public boolean deleteUserbyId(int id) {
		return employeeDao.deleteUserbyId(id);
	}

}
