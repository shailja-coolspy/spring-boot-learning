package com.example.springBoot.validationdemo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	//add an initblinder...to convert trim input strings
	//remove leading and trailing whiteapace
	//resolve issue for our validation
	@InitBinder
	public void initBlinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showForm(Model theMode) {
		
		theMode.addAttribute("customer", new Customer());
		
		return "customerForm";
	}
	
	//@valid-tell to validate the form
	//@ModelAttribute- to read data submitted in the form
	//Binding result is the result of validation
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")Customer thCustomer,BindingResult theBindingResult) {
		
		//debugging binding result::
		System.out.println("Binding Result: "+theBindingResult.toString());
		
		if(theBindingResult.hasErrors()) {
			return "customerForm";
		}else {
			return "customer-confirmation";
		}
	}

}
