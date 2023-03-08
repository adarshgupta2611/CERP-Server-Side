package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EntityNotFoundException;
import com.app.dto.StudentRequestDto;
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
	public Student addStudent(StudentRequestDto studentdto, Long courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
		Student st = studentRepository.findByEmailAndPassword(studentdto.getEmail(), studentdto.getPassword());
		if(st == null) {
		Student student = new Student();
		student.setFirstName(studentdto.getFirstName());
		student.setLastName(studentdto.getLastName());
		student.setEmail(studentdto.getEmail());
		student.setGender(studentdto.getGender());
		student.setPassword(studentdto.getPassword());
		student.setAddress(studentdto.getAddress());
		student.setCourse(course);
		return studentRepository.save(student);
		}
		else {
			return null;
		}
	}

	@Override
	public Student getStudentDetails(Long studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(()->new EntityNotFoundException("Student not found with id: "+studentId));
	}
	
	@Override
	public Student authenticateStudent(String email, String password) {
		return studentRepository.findByEmailAndPassword(email, password);
	}
}
