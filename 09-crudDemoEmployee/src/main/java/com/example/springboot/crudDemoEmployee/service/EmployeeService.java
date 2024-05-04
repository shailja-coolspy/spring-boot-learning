package com.example.springboot.crudDemoEmployee.service;

import java.util.List;

import com.example.springboot.crudDemoEmployee.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);


}
