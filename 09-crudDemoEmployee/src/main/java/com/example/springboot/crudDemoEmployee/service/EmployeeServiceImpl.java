package com.example.springboot.crudDemoEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.crudDemoEmployee.dao.EmployeeDAO;
import com.example.springboot.crudDemoEmployee.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO thEmployeeDAO) {
		// TODO Auto-generated constructor stub
		
		employeeDAO=thEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		employeeDAO.deleteById(theId);
		
	}

}
