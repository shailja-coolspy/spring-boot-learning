package com.springbootdemo.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	

	public TennisCoach() {
		System.out.println("In constructor:"+getClass().getName());

		// TODO Auto-generated constructor stub
	}

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Spend 40 min in tennis practice every day";
	}

}
