package com.example.springBoot.aopDemo.dao;

import java.util.List;

import com.example.springBoot.aopDemo.Account;

public interface AccountDao {
	
	void addAccount();
	
	List<Account>findAccount();

	List<Account> findAccount(boolean tripWise);

}
