package com.example.springBoot;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springBoot.dao.AppDAO;
import com.example.springBoot.entity.Course;
import com.example.springBoot.entity.Instructor;
import com.example.springBoot.entity.InstructorDetail;
import com.example.springBoot.entity.Review;

@SpringBootApplication
public class CrudDemoAdvMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoAdvMappingApplication.class, args);
	}
	
	//execute after spring bean have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		
		return runner->{
			//deleteInstructorDetail(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructor(appDAO);
			//findInstructor(appDAO);
			//createInstructor(appDAO);
			//System.out.println("Hello World");
			//createInstructorWithCourses(appDAO);
			
			//eager vs lazy
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstrutor(appDAO);
			
			//findInstructorWithCoursesJoinFetch(appDAO);
			
			//updateInstructor(appDAO);
			
			//updateCourse(appDAO);
			
			//deleteInstructor(appDAO);
			
			//deleteCourseById(appDAO);
			
			
			//one to many-uni directional
			
			//createCourseAndReviews(appDAO);
			
			//retrieveCourseAndReview(appDAO);
			
			deleteCourseAndReview(appDAO);
			
		};
		
	}
	
	private void deleteCourseAndReview(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=10;
		
		System.out.println("Deleting course id: "+theId);
		
		appDAO.deleteCourseById(theId);
		
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		//get the course and review
		int theId=10;
		
		Course tempCourse=appDAO.findCourseAndReviewByCourseId(theId);
		
		//print the courses
		System.out.println(tempCourse);
		
		//print review
		System.out.println(tempCourse.getReviews());
		
		System.out.println("Done!!");
		
		
		
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		//create a course
		Course tempCourse=new Course("Pacman-How to score one millian points");
		
		//add some reviews
		tempCourse.addReview(new Review("Great corse"));
		tempCourse.addReview(new Review("Great corse comment one"));
		tempCourse.addReview(new Review("Great corse comment two"));
		
		//save the course..and leverage the cascade all
		System.out.println("Save the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDAO.save(tempCourse);
		
		System.out.println("Done!!");
	}

	private void deleteCourseById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=10;
		System.out.println("Deleting course id: "+theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done!!");
	}

	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=10;
		
		System.out.println("Finding course id: "+theId);
		Course tempCourse=appDAO.findCourseById(theId);
		
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the simple things");
		
		appDAO.updateCourse(tempCourse);
		
		System.out.println("DONE !!");
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		
		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		
		//update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("ANSHU");
		
		appDAO.updateInstructor(tempInstructor);
		
		System.out.println("Done !!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=1;
		
		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		
		System.out.println("Done!");
		
	}

	private void findCoursesForInstrutor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		//fetch.lazy
		//find instructor
		System.out.println("Finding instructor id: "+theId);
		
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		
		
		//find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);
		
		tempInstructor.setCourses(courses);
		System.out.println("the associated course: "+tempInstructor.getCourses());
		
		System.out.println("Done !!");
		
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=1;
		
		System.out.println("Find instructor id: "+theId);
		
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		
		System.out.println("Done!!");
		
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		
		// create the instructor
				Instructor tempInstructor =
						new Instructor("Shailja", "Agarwal", "agarwal@luv2code.com");

				// create the instructor detail
				InstructorDetail tempInstructorDetail =
						new InstructorDetail(
								"http://www.luv2code.com/youtube",
								"Coding");

				// associate the objects
				tempInstructor.setInstructorDetail(tempInstructorDetail);
				
				
				//create some courses
				
				Course tempCourse1=new Course("Air Coiding class");
				Course tempCourse2=new Course("abc dance class");

				
				//add courses to instructor
				tempInstructor.add(tempCourse1);
				tempInstructor.add(tempCourse2);
				
				//save the instructor
				//NOTE:this will also save the course because of cascadeType.persist
				
				System.out.println("Saving instructor: "+tempInstructor);
				System.out.println("The corses: "+tempInstructor.getCourses());
				appDAO.save(tempInstructor);
				
				System.out.println("Done!!");
		
	}
	
	private void deleteInstructorDetail(AppDAO appDAO) {
		
		int theId=2;
		System.out.println("Deleting instructor detail id: "+theId);
		
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}
	
	private void findInstructorDetail(AppDAO appDAO) {
		
		//get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);
		
		//print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		
		//print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
		
		System.out.println("Done!");
	}
	
	private void deleteInstructor(AppDAO appDAO) {
		
		int theId=1;
		
		System.out.println("Deleting instructor id: "+theId);
		
		appDAO.deleteInstructorById(theId);
		
		System.out.println("Done!!");
	}
	
	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		
		System.out.println("Finding instructor id:"+theId);
		
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		
		System.out.println("the associated instructorDetail only"+tempInstructor.getInstructorDetail());
	}
	
	private void createInstructor(AppDAO appDAO) {
		
		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!!!");
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
		
	}

}
