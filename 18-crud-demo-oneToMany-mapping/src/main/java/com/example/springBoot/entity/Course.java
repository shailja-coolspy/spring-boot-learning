package com.example.springBoot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	//define our fields
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="title")
	private String title;
	
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name ="instructor_id" )
	private Instructor instructor;
	
	

	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String title) {
		super();
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	//define constructor;
	
	
	
	//define getter and setters
	
	//define toString()
	
	//annotate fields
	
}
