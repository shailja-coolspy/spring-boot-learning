package com.example.springboot.crudDemoEmployee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.crudDemoEmployee.entity.Employee;

import jakarta.persistence.*;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	
	//define field for entity manager
	
  	private EntityManager entityManager;
  	
  	//set up constructor injection
  	
  	@Autowired
  	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
  		
  		entityManager=theEntityManager;
  		
  	}
  	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		//create query
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get result
		List<Employee> employees=theQuery.getResultList();
		
		//return the result
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		//get employee
		Employee theEmployee=entityManager.find(Employee.class, theId);
		
		//return employee
		return theEmployee;
	}


	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		//save employee
		Employee dbEmployee=entityManager.merge(theEmployee);
		
		
		//return the employee
		return dbEmployee;
	}

	
	//NOTE:: we do not use @transactional at DAO layer ,It will be handled at service layer

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		//get employee by the id
		Employee thEmployee=entityManager.find(Employee.class, theId);
		
		//remove the employee
		entityManager.remove(thEmployee);
		
	}

}
