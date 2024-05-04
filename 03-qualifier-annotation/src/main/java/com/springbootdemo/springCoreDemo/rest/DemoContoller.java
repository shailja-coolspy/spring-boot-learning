package com.springbootdemo.springCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.springCoreDemo.common.Coach;

@RestController
public class DemoContoller {
	
	//define private field for the dependency
	private Coach mycoach;
	
	//define constructor for dependency
	//if one constructor then no need of @autowired
//	@Autowired
//	public DemoContoller(@Qualifier("baseBallCoach") Coach mycoach) {
//		this.mycoach = mycoach;
//	}
	
	@Autowired
	public void setMycoach( @Qualifier("tennisCoach") Coach mycoach) {
		this.mycoach = mycoach;
	}
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return mycoach.getdialyWorkOut();
		
	}
	
	

}
