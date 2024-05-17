package com.example.springBoot.aopDemo;
import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springBoot.aopDemo.dao.AccountDao;
import com.example.springBoot.aopDemo.dao.MembershiDAO;
import com.example.springBoot.aopDemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDao,MembershiDAO theMembershiDAO,TrafficFortuneService theTrafficFortuneService)
	{
		return runner->{
			//System.out.println("Hello World!!");
			//demoTheBeforeAdvice(theAccountDao,theMembershiDAO);
			//demoTheAfterReturningAdvice(theAccountDao);
			//demoTheAfterThrowingAdvice(theAccountDao);
			//demoTheAfterAdvice(theAccountDao);
			//demoTheAroundAdvice(theTrafficFortuneService);
			
			demoTheAroundAdviceHandleException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		// TODO Auto-generated method stub
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWise=true;
		String data=theTrafficFortuneService.getFortune(tripWise);
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		// TODO Auto-generated method stub
		
		System.out.println("\nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data=theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDao theAccountDao) {
		// TODO Auto-generated method stub
		List<Account> theAccounts=null;
		
	     try {
	    	 //add a boolean flag to simulate exception
	    	 boolean tripWise=true;
	    	 theAccounts=theAccountDao.findAccount(tripWise);
	     }
	     catch(Exception exc) {
	 		System.out.println("\n\nMain Program:....caught exception "+exc);

	     }
	     
			System.out.println("\n\nMain Program:demoTheAfterThrowingAdvice");
			
			System.out.println("--------");
			
			System.out.println(theAccounts);
			
			System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDao theAccountDao) {
		// TODO Auto-generated method stub
     List<Account> theAccounts=null;
		
     try {
    	 //add a boolean flag to simulate exception
    	 boolean tripWise=true;
    	 theAccounts=theAccountDao.findAccount(tripWise);
     }
     catch(Exception exc) {
 		System.out.println("\n\nMain Program:....caught exception "+exc);

     }
     
		System.out.println("\n\nMain Program:demoTheAfterThrowingAdvice");
		
		System.out.println("--------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		
	}

	private void demoTheAfterReturningAdvice(AccountDao theAccountDao) {
		// TODO Auto-generated method stub
		
		List<Account> theAccounts=theAccountDao.findAccount();
		
		System.out.println("\n\nMain Program:demoTheAfterReturningAdvice");
		
		System.out.println("--------");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDao,MembershiDAO theMembershiDAO) {
		// TODO Auto-generated method stub
		theAccountDao.addAccount();
		
		theMembershiDAO.addAccount();
		
	}

}
