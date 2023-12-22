package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Subject extends BaseEntity {
	@NotBlank(message = "Subject name is required")
	private String subjectName;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;
	
	public Subject(@NotBlank(message = "Subject name is required") String subjectName, Course course) {
		super();
		this.subjectName = subjectName;
		this.course= course;
	}

	public Subject() {
		super();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", course=" + course + "]";
	}
	
	
}