package com.example.crudSpringBootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudSpringBootdemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository //component scanning
public class StudentDAOImpl implements StudentDAO {
	
	//definr fileld for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
		// TODO Auto-generated constructor stub
	}
	
	
	//implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		// TODO Auto-generated method stub
		
	}


	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class,id);
	}


	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		//create query:::"Student" JPA Entity is class Name
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);
		
		//return query results
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		//create query
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

		
		//set query parameter
		theQuery.setParameter("theData", theLastName);
		
		//return query result
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		//retrieve the student
		Student theStudent=entityManager.find(Student.class, id);
		
		//delete the student
		entityManager.remove(theStudent);
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		return numRowDeleted;
	}

}
