package com.springbootdemo.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy //this will be initilized when needed
public class BaseBallCoach implements Coach {
	
	

	public BaseBallCoach() {
		System.out.println("In constructor:"+getClass().getName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Spend 30 min in base ball practice";
	}
	
	

}
