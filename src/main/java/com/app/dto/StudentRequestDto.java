package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentRequestDto {
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String password;
	private String address;
	private Long courseId;
	public StudentRequestDto(String firstName, String lastName, String email, String gender, String password,
			String address, Long courseId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.courseId = courseId;
	}
	
	
	
}
