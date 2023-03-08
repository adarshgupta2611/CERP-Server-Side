package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity

public class Student extends BaseEntity{
	@Column(length = 20)
	@NotBlank(message = "First Name is required")
	@Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	@NotBlank(message = "Email id is required")
	@Email(message = "Invalid Email address")
	private String email;
	@NotBlank(message = "Gender should not be blank")
	private String gender;
	@Column(length = 20,nullable = false)
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})",message = "Invalid Password!")
	private String password;
	@Column(length=50)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	public Student(
			@NotBlank(message = "First Name is required") @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters") String firstName,
			String lastName,
			@NotBlank(message = "Email id is required") @Email(message = "Invalid Email address") String email,
			@NotBlank(message = "Gender should not be blank") String gender,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password should have at least 6 characters") @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})", message = "Invalid Password!") String password,
			String address, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.course = course;
	}

	public Student() {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", address=" + address + ", course=" + course + "]";
	}

	
	
}
