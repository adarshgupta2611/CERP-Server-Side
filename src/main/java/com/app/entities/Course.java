package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity {
	private String courseName;
	
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Student> students = new ArrayList<>();
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
}
