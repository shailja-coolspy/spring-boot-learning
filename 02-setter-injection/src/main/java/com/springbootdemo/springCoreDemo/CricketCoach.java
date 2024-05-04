package com.springbootdemo.springCoreDemo;

import org.springframework.stereotype.Component;

@Component //creates bean object of the class
public class CricketCoach implements Coach {

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice fast bolwig every 15 minutes";
	}

}
