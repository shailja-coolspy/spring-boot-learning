package com.example.springBoot.dao;

import com.example.springBoot.entity.Instructor;
import com.example.springBoot.entity.InstructorDetail;


public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	
	void deleteInstructorDetailById(int theId);

}
