package com.example.springboot.crudDemoEmployee.dao;

import java.util.*;

import com.example.springboot.crudDemoEmployee.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

}
