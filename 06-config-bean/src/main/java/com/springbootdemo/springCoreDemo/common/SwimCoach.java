package com.springbootdemo.springCoreDemo.common;

public class SwimCoach implements Coach{

	public SwimCoach() {
		// TODO Auto-generated constructor stub
		System.out.println("In constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getdialyWorkOut() {
		// TODO Auto-generated method stub
		return "Swim 1000 meter as warm up";
	}

}
