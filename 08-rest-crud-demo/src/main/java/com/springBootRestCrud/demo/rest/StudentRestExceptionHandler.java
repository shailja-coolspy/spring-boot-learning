package com.springBootRestCrud.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//global exception

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add exception handling code here
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a StudentErrorResponse
		StudentErrorResponse error= new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	

	//add another exception handler.. to catch any exception (catch all)
	//this in case in place of interger value string is passed in endpoint for studentId
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//create a StudentErrorResponse
				StudentErrorResponse error= new StudentErrorResponse();
				
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage(exc.getMessage());
				error.setTimeStamp(System.currentTimeMillis());
				
				//return ResponseEntity
				return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	

}
