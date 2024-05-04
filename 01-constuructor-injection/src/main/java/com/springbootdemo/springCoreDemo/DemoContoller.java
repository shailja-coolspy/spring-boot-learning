package com.springbootdemo.springCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoContoller {
	
	//define private field for the dependency
	private Coach mycoach;
	
	//define constructor for dependency
	//if one constructor then no need of @autowired
	@Autowired
	public DemoContoller(Coach mycoach) {
		super();
		this.mycoach = mycoach;
	}
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return mycoach.getdialyWorkOut();
		
	}
	
	

}
