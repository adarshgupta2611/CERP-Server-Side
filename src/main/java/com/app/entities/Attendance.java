package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Attendance extends BaseEntity {
	@Range(min = 0, max = 100, message = "Attendance percentage should be between 0-100 only")
	private int attendance;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	@JsonIgnore
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
	
	public Attendance(
			@Range(min = 0, max = 100, message = "Attendance percentage should be between 0-100 only") int attendance) {
		super();
		this.attendance = attendance;
	}

	public Attendance(
			@Range(min = 0, max = 100, message = "Attendance percentage should be between 0-100 only") int attendance,
			Subject subject, Student student) {
		super();
		this.attendance = attendance;
		this.subject = subject;
		this.student = student;
	}

	public Attendance() {
		super();
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Attendance [attendance=" + attendance + ", subject=" + subject + ", student=" + student + "]";
	}
	
	
	
	
}
