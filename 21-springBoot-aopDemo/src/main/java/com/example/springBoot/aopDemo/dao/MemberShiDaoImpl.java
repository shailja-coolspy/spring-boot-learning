package com.example.springBoot.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShiDaoImpl implements MembershiDAO {

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+":DOING MY DB WORK: ADDING AN ACCOUNT : MemberShiDAOImpl");
	}

}
