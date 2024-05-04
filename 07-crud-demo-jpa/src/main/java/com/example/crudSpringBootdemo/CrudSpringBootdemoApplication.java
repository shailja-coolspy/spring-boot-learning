package com.example.crudSpringBootdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crudSpringBootdemo.dao.StudentDAO;
import com.example.crudSpringBootdemo.entity.Student;

@SpringBootApplication
public class CrudSpringBootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootdemoApplication.class, args);
	}
	
	//@Bean
//	public CommandLineRunner commandLineRunner(String[] args) {
//		return runner->{
//			System.out.println("Hello World");
//		};
//	}
	
	//inject StudentDAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {
		return runner->{
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);
			
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all student....");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
		
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);
		
		//change first name to "Scooby"
		System.out.println("Updating the Student...");
		myStudent.setFirstName("Scooby");
		
		//update the student
		studentDAO.update(myStudent);
		
		//display the update student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Gupta");
		
		//display list of students
		for(Student tempStudent:theStudents) {
			System.out.println(theStudents);
		}
		
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//get list of student
		List<Student> theStudents=studentDAO.findAll();
		
		//display list of student
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Anshuman","Agarwal","anshuman@gmail.com");
		
		//save the student
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		
		
		//display id of the saved student
		System.out.println("Saved Student,Generated Id="+tempStudent.getId());

		
		//retrieve student based on the id: primary key
		System.out.println("Retriving student with id:"+tempStudent.getId());
		Student myStudent=studentDAO.findById(tempStudent.getId());
		
		//display student
		System.out.println("Found the student:"+myStudent);
		
		
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		// create then student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Raja","Gupta","rajagupta1@try.com");
		
		// save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		
		//display id of the saved student
		System.out.println("Saved Student,Generated Id="+tempStudent.getId());
	}
	

}
