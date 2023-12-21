package com.app.controller;

import com.app.dto.StudentCredentials;
import com.app.dto.StudentRequestDto;
import com.app.entities.Student;
import com.app.security.JwtHelper;
import com.app.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private JwtHelper jwtHelper;
	
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
    public ResponseEntity<?> login(@RequestBody StudentCredentials studentCredential) {
		
		Student student =studentService.authenticateStudent(studentCredential.getEmail(), studentCredential.getPassword());

        if (student != null) {
			String token = jwtHelper.generateToken(student.getEmail(), Map.of("id", student.getId()));
            return ResponseEntity.ok(Map.of("token",token,"id",student.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    } 
}