package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Subject extends BaseEntity {
	@NotBlank(message = "Subject name is required")
	private String subjectName;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;
	
	public Subject(@NotBlank(message = "Subject name is required") String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	
	
}
