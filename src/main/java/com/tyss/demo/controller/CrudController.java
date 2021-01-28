package com.tyss.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.demo.dto.Employee;
import com.tyss.demo.service.EmployeeService;


@Controller
public class CrudController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getusers")
	public String fetchUsers(ModelMap map) {
		List<Employee> list=employeeService.listOfEmployee();
		map.addAttribute("employeeList", list);
		return "users";
	}
	@PostMapping("/addUser")
	public String addUser(String name,String address) {
		employeeService.addUser(name, address);
		return "redirect:/getusers";
	}
	@GetMapping("/fetchUserById/{id}")
	public String fetchUserById(@PathVariable("id") String id,ModelMap map) {
		Employee employee=employeeService.fetchUserById(Integer.parseInt(id));
		map.addAttribute("employee", employee);
		return "update";
	}
	@GetMapping("fetchUserById/updateUser/{id}")
	public String updateUser(@PathVariable("id") String id,@RequestParam("name")String name,@RequestParam("address")String address) {
		System.out.println(id+" "+name+" "+address);
		employeeService.updateUser(new Employee(Integer.parseInt(id),name,address));
		return "redirect:/getusers";
	}
	@GetMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable("id") String id,ModelMap map) {
		boolean flag=employeeService.deleteUserbyId(Integer.parseInt(id));
		if(flag) {
		return "redirect:/getusers";
		}else {
			return "redirect:/getusers";
		}
	}
}
