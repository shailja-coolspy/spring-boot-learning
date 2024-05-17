package com.example.springBoot.aopDemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.TimeUtil;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning";
	}

	@Override
	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!!");
		}
		return getFortune();
	}

}
