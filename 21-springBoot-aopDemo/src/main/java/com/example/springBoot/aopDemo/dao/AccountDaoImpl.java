package com.example.springBoot.aopDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springBoot.aopDemo.Account;

//used for component scanning @repository
@Repository
public class AccountDaoImpl implements AccountDao {

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+":DOING MY DB WORK: ADDING AN ACCOUNT : In AccountDAOImpl");
	}

	@Override
	public List<Account> findAccount() {
		// TODO Auto-generated method stub
		//@AfterReturning
//		List<Account> myAccounts=new ArrayList<>();
//		
//		Account temp1=new Account("Shailja","Gold");
//		Account temp2=new Account("Anshu","Silver");
//
//		Account temp3=new Account("Ruby","Platinum");
//		
//		myAccounts.add(temp1);
//		myAccounts.add(temp2);
//		myAccounts.add(temp3);
//
//		
//		
//		return myAccounts;
		
		
		
		//@AfterThrowing
		return findAccount(false);
	}

	@Override
	public List<Account> findAccount(boolean tripWise) {
		// TODO Auto-generated method stub
		
		//for testing purpose...made an exception
		if(tripWise) {
			throw new RuntimeException("No soup for you!!!");
		}
		List<Account> myAccounts=new ArrayList<>();
		
		Account temp1=new Account("Shailja","Gold");
		Account temp2=new Account("Anshu","Silver");

		Account temp3=new Account("Ruby","Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		
		
		return myAccounts;
	}

}
