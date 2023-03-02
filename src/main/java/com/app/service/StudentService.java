package com.app.service;

import com.app.dto.StudentRequestDto;
import com.app.entities.Student;

public interface StudentService {
	Student addStudent(StudentRequestDto student, Long courseId);
	Student getStudentDetails(Long studentId);
	Student authenticateStudent(String email, String password);
}
