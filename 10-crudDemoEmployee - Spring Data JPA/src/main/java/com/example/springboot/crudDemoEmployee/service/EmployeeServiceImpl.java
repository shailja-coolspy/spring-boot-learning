package com.example.springboot.crudDemoEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.crudDemoEmployee.dao.EmployeeRepository;
import com.example.springboot.crudDemoEmployee.entity.Employee;

//import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository thEmployeeRepository) {
		// TODO Auto-generated constructor stub
		
		employeeRepository=thEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		//Optional- it was introduced in java 8
		Optional<Employee> result= employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		if(result.isPresent()) {
			
			theEmployee=result.get();
			
		}else {
			// we did not find the employee
			throw new RuntimeException("Did not find employee id-" + theId);
		}
		
		return theEmployee;
	}
	

	@Override
	//@Transactional-jpa repository provides this functionality out of the box
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}

	@Override
	//@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(theId);
		
	}

}
