package com.app.service;

import com.app.entities.Student;

public interface StudentService {
	Student addStudent(Student student, Long courseId);
}
