package com.example.springBoot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springBoot.entity.Course;
import com.example.springBoot.entity.Instructor;
import com.example.springBoot.entity.InstructorDetail;
import com.example.springBoot.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
	
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		entityManager.persist(theInstructor);
		
	}


	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, theId);
	}


	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		//retrieve the instructor
		Instructor tempInstructor=entityManager.find(Instructor.class, theId);
		
		//get the course
		List<Course> courses=tempInstructor.getCourses();
		
		//break association of all courses for the instructor
		for(Course tempCourse:courses) {
			//remove the instructor from the course
			tempCourse.setInstructor(null);
		}
		
		//delete the instructor
		//we only delete the instructor..not the associated courses based on our cascade types
		entityManager.remove(tempInstructor);
		
	}


	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class, theId);
	}


	@Override
	public void deleteInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		
		//retrive instructor detail
		InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class, theId);
		
		//delete the instructor detail
		entityManager.remove(tempInstructorDetail);
		
	}


	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		// TODO Auto-generated method stub
		
		//created query
		TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data",Course.class);
		
		query.setParameter("data", theId);
		
		//execute query
		List<Course> courses=query.getResultList();
		
		return courses;
	}


	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		// TODO Auto-generated method stub
		
		
		        // create query
		        TypedQuery<Instructor> query = entityManager.createQuery(
		                                                "select i from Instructor i "
		                                                    + "JOIN FETCH i.courses "
		                                                    + "JOIN FETCH i.instructorDetail "
		                                                    + "where i.id = :data", Instructor.class);
		        query.setParameter("data", theId);

		        // execute query
		        Instructor instructor = query.getSingleResult();

		        return instructor;
		  	}


	//update instructor
	
	@Override
	@Transactional
	public void updateInstructor(Instructor tempInstructor) {
		// TODO Auto-generated method stub
		entityManager.merge(tempInstructor);
		
	}

	
	
	//update course
	@Override
	@Transactional
	public void updateCourse(Course temCourse) {
		// TODO Auto-generated method stub
		entityManager.merge(temCourse);
	}


	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, theId);
	}


	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		
		//retrieve the course
		Course tempCourse=entityManager.find(Course.class, theId);
		
		//delete the course
		entityManager.remove(tempCourse);
		
	}


	//will save course and associated reviews bcz of cascade.all
	@Override
	@Transactional
	public void save(Course theCourse) {
		// TODO Auto-generated method stub
		entityManager.persist(theCourse);
		
	}


	@Override
	public Course findCourseAndReviewByCourseId(int theId) {
		// TODO Auto-generated method stub
		
		 // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :data", Course.class);

        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;
	}


	@Override
	public Course findCourseAndStudentByCourseId(int theId) {
		// TODO Auto-generated method stub
		 // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.students "
                + "where c.id = :data", Course.class);

        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;

	}


	@Override
	public Student findStudentAndCoursesByStudentId(int theId) {
		// TODO Auto-generated method stub
		 // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                + "JOIN FETCH s.courses "
                + "where s.id = :data", Student.class);

        query.setParameter("data", theId);

        // execute query
        Student student = query.getSingleResult();

        return student;
	}


	@Override
	@Transactional
	public void update(Student tempStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(tempStudent);
	}


	@Override
	@Transactional
	public void deleteStudentById(int theId) {
		// TODO Auto-generated method stub
		
		//retrive the student
		Student tempStudent=entityManager.find(Student.class, theId);
		
		//delete the student
		entityManager.remove(tempStudent);
		
	}

}
