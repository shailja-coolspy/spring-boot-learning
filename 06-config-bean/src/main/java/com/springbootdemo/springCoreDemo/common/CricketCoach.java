package com.springbootdemo.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component //creates bean object of the class
public class CricketCoach implements Coach {
	
	

	public CricketCoach() {
		System.out.println("In constructor:"+getClass().getName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice fast bolwig every 15 minutes";
	}

}
