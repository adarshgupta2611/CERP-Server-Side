package com.app.controller;

import com.app.dto.AdminDto;
import com.app.entities.Admin;
import com.app.entities.Subject;
import com.app.security.JwtHelper;
import com.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtHelper jwtHelper;


    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody AdminDto admindto) {
        Admin admin = adminService.authenticateAdmin(admindto.getEmail(), admindto.getPassword());
        if (admin != null) {
            String token = jwtHelper.generateToken(admin.getEmail(), Map.of("id", admin.getId()));
            return ResponseEntity.ok(Map.of("token", token, "id", admin.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getCourseList() {
        return ResponseEntity.ok(adminService.getCourseList());
    }

    @GetMapping("/courses/{courseName}")
    public ResponseEntity<?> getSubjectList(@PathVariable String courseName) {
        List<Subject> subjects = adminService.getSubjectList(courseName);
        if (subjects != null) {
            return ResponseEntity.ok(subjects);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid course name");
        }
    }

}