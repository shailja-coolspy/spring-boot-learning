package com.springbootdemo.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Spend 40 min in tennis practice every day";
	}

}
