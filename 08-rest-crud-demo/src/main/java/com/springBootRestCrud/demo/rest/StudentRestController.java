package com.springBootRestCrud.demo.rest;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.springBootRestCrud.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//defile @PostConstruct to load the student only once
	@PostConstruct
	public void loadData() {
		
		theStudents=new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Shailja", "Sanghai"));
		theStudents.add(new Student("Anshuman", "Agarwal"));
		
	}
	
	//define end point "/students" -return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
//		List<Student> theStudents=new ArrayList<>();
//		
//		theStudents.add(new Student("Poornima", "Patel"));
//		theStudents.add(new Student("Shailja", "Sanghai"));
//		theStudents.add(new Student("Anshuman", "Agarwal"));

		
		return theStudents;
	}
	
	//define endpoint or "/students/{studentId}"-return student at index
	//By default variable name should match of {studentId} and int studentId
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//check the studentId again list size
		
		if((studentId>=theStudents.size())|| (studentId<0)) {
			throw new StudentNotFoundException("Student id not found-"+studentId);
		}
		
		//this is retrieving based on index
		return theStudents.get(studentId);
	}
	
	
	//add exception handling using @ExceptionHandler
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//		
//		//create a StudentErrorResponse
//		StudentErrorResponse error= new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		//return ResponseEntity
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
	
	
	//add another exception handler.. to catch any exception (catch all)
	//this in case in place of interger value string is passed in endpoint for studentId
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//		//create a StudentErrorResponse
//				StudentErrorResponse error= new StudentErrorResponse();
//				
//				error.setStatus(HttpStatus.BAD_REQUEST.value());
//				error.setMessage(exc.getMessage());
//				error.setTimeStamp(System.currentTimeMillis());
//				
//				//return ResponseEntity
//				return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//	}
	

}
