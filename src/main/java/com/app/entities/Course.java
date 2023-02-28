package com.app.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity {
	private String courseName;

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	
	
}
