package com.springbootdemo.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Spend 30 min in base ball practice";
	}
	
	

}
