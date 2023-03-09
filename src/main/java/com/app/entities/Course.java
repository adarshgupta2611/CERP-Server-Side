package com.app.entities;

import javax.persistence.Entity;

@Entity

public class Course extends BaseEntity {
	private String courseName;


	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}



	public Course() {
		super();
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	@Override
	public String toString() {
		return "Course [courseName=" + courseName  +"]";
	}



}
