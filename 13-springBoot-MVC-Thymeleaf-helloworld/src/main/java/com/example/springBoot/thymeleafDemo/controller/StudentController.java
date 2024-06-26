package com.example.springBoot.thymeleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springBoot.thymeleafDemo.model.Student;

@Controller
public class StudentController {
	
	
	//injecting value from application.properties file:::
	@Value("${countries}")
	private List<String> countries;
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
		
		//create a student object
		Student theStudent=new Student();
		
		//add student object to the model
		theModel.addAttribute("student", theStudent);
		
		//add the list of countries to the model
		theModel.addAttribute("countries", countries);
		
		return "student-form";
		
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student")Student theStudent) {
		
		//log the input data
		System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}
}
