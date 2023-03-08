package com.app.dto;

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
	public StudentRequestDto() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "StudentRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender="
				+ gender + ", address=" + address + ", courseId=" + courseId + "]";
	}
	
	
	
	
	
}
