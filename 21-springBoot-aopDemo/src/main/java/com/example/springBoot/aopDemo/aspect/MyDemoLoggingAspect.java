package com.example.springBoot.aopDemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.springBoot.aopDemo.Account;


//aspect has related advices
@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advice for logging
	
	//lets start with an @Before advice
	//"execution(public void addAccount())"--is pointcut expression
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("//////......Executing @before advice addAcoount() ");
	}
	
	
	
	
	
	@AfterReturning(pointcut = "execution(* com.example.springBoot.aopDemo.dao.AccountDao.findAccount(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		
		//print out which method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @AfterReturnig on method: "+method);
		
		//print out the result of the method call
		System.out.println("\n===>>> result is: "+result);
	}
	
	
	
	
	
	@AfterThrowing(pointcut = "execution(* com.example.springBoot.aopDemo.dao.AccountDao.findAccount(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		//print out which method we are advising on
				String method=theJoinPoint.getSignature().toShortString();
				System.out.println("\n===>>> Executing @AfterThrowing on method: "+method);
				
				//print out the result of the method call
				System.out.println("\n===>>> result is: "+theExc);
	}
	
	
	
	
	
	@After("execution(* com.example.springBoot.aopDemo.dao.AccountDao.findAccount(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @After(finally) on method: "+method);

	}

}
