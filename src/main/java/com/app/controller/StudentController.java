package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Student;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> studentRegistration(@Valid @RequestBody Student student, @RequestBody Long courseId){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student, courseId));
	}
}
