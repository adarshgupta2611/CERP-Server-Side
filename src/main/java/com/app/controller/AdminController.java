package com.app.controller;

import java.util.List;

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

import com.app.dto.AdminDto;
import com.app.entities.Admin;
import com.app.entities.Subject;
import com.app.service.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody AdminDto admindto) {

		Admin admin  =adminService.authenticateAdmin(admindto.getEmail(), admindto.getPassword());
		if (admin != null) {
			return ResponseEntity.ok(admin.getId());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
	} 

	@GetMapping("/courses")
	public ResponseEntity<?> getCourseList(){
		return ResponseEntity.ok(adminService.getCourseList());
	}

	@GetMapping("/courses/{courseName}")
	public ResponseEntity<?> getSubjectList(@PathVariable String courseName){
		List<Subject> subjects = adminService.getSubjectList(courseName);
		if(subjects!=null) {
			return ResponseEntity.ok(subjects);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid course name");

		}
	}	
}
