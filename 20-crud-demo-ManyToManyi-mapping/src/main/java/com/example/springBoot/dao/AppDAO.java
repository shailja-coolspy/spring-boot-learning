package com.example.springBoot.dao;

import java.util.List;

import com.example.springBoot.entity.Course;
import com.example.springBoot.entity.Instructor;
import com.example.springBoot.entity.InstructorDetail;
import com.example.springBoot.entity.Student;


public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	Course findCourseById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCoursesByInstructorId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	//update instructor
	void updateInstructor(Instructor tempInstructor);
	
	//update course
	
	void updateCourse(Course temCourse);
	
	//delete course
	void deleteCourseById(int theId);
	
	//SAVE A COURSE
	void save(Course  theCourse);
	
	Course findCourseAndReviewByCourseId(int theId);
	
	//Many to Many::
	
	Course findCourseAndStudentByCourseId(int theId);
	
	Student findStudentAndCoursesByStudentId(int theId);
	
	//add more courses to students
	void update(Student tempStudent);
	
	void deleteStudentById(int theId);
	
	

}
