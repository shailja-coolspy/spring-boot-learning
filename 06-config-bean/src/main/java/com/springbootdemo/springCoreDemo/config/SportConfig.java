package com.springbootdemo.springCoreDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootdemo.springCoreDemo.common.Coach;
import com.springbootdemo.springCoreDemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}

}
