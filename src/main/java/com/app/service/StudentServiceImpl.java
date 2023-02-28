package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EntityNotFoundException;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student, Long courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
		student.setCourse(course);
		return studentRepository.save(student);
	}

}
