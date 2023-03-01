package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentRequestDto;
import com.app.service.StudentService;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> studentRegistration(@Valid @RequestBody StudentRequestDto student){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student, student.getCourseId()));
	}
}
