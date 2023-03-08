package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentCredentials;
import com.app.dto.StudentRequestDto;
import com.app.entities.Student;
import com.app.service.StudentService;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> studentRegistration(@Valid @RequestBody StudentRequestDto student){
		Student st = studentService.addStudent(student, student.getCourseId());
		if(st!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(st);
		}
		else {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Student already signed up");
		}
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentDetails(@PathVariable Long studentId){
		return ResponseEntity.ok(studentService.getStudentDetails(studentId));
	}
	
	@PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody StudentCredentials studentcredential) {
		
		Student student =studentService.authenticateStudent(studentcredential.getEmail(), studentcredential.getPassword());

        if (student != null) {
            return ResponseEntity.ok(student.getId());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    } 
}
