package com.example.springBoot.aopDemo;

public class Account {

	private String name;
	
	private String level;

	public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	
}
