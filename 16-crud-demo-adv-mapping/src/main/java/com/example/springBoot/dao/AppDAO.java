package com.example.springBoot.dao;

import com.example.springBoot.entity.Instructor;


public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);

}
