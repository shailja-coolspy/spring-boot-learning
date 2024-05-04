package com.example.springboot.crudDemoEmployee.rest;

import java.util.*;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.springboot.crudDemoEmployee.dao.EmployeeDAO;
import com.example.springboot.crudDemoEmployee.entity.Employee;
import com.example.springboot.crudDemoEmployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	private EmployeeService employeeService;
	//private EmployeeDAO employeeDAO;

	
	//quick and dirty: inject employee service (use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
//		employeeDAO=theEmployeeDAO;
//	}
	
	
	//expose "/employees" and return a list of employee
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	//add mapping for GET /employee/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId) ;
		
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found- "+employeeId);
		}
		
		return theEmployee;
	}
	
	//add mapping for POST /employees-add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//also just in case they pass an id in JSON..SET ID TO 0
		
		//this is to force a save of new item...instead of update
		
		theEmployee.setId(0);
		
		Employee dbEmployee= employeeService.save(theEmployee);
		
		return dbEmployee;
		
	}
	
	
	//add mapping for PUT /employee- update existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee=employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	//add mapping for DELETE /employees/{employeeId}--delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee=employeeService.findById(employeeId);
		
		if(tempEmployee==null) {
			throw new RuntimeException("Employee id not found-"+ employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id-" + employeeId;
	}
	
	

}
