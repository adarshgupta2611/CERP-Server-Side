package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
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
}
