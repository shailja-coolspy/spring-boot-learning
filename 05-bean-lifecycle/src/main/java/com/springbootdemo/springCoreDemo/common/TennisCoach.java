package com.springbootdemo.springCoreDemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
	
	

	public TennisCoach() {
		System.out.println("In constructor:"+getClass().getName());

		// TODO Auto-generated constructor stub
	}
	
	//init method:::
	@PostConstruct
	public void doMyStartUpStuffs() {
		System.out.println("In doMyStartUpStuff:"+getClass().getSimpleName());
	}
	
	
	//destroy method::
	@PreDestroy
	public void doMySCleanUpStuffs() {
		System.out.println("In doMyCleanUpStuff:"+getClass().getSimpleName());
	}
	

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Spend 40 min in tennis practice every day";
	}

}
