package com.example.springboot.crudDemoEmployee.dao;


import com.example.springboot.crudDemoEmployee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
