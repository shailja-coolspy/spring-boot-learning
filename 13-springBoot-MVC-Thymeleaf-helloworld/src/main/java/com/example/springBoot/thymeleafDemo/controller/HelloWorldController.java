package com.example.springBoot.thymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	//need a controller method to show initial html form
//	@RequestMapping("/showForm")//requestMapping support any requesr method get,post etc..
//	public String showForm() {
//		return "helloworld-form";
//	}
	
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	//need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//need a controller method to read form data and--Addinj data to spring mvc model
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		
		//read the request parameter from the HTMLform
		String theName=request.getParameter("studentName");
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Yo!"+theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName,Model model) {
		
		//read the request parameter from the HTMLform
		//String theName=request.getParameter("studentName");
		
		//convert the data to all caps
		theName=theName.toUpperCase();
		
		//create the message
		String result="Hey My Freiend from v3 :"+theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
