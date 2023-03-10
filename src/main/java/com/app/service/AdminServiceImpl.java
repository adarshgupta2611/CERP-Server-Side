package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Admin;
import com.app.entities.Course;
import com.app.entities.Subject;
import com.app.repository.AdminRepository;
import com.app.repository.CourseRepository;
import com.app.repository.SubjectRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public Admin authenticateAdmin(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Course> getCourseList() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	@Override
	public List<Subject> getSubjectList(String courseName) {
		Course course =  courseRepository.findByCourseName(courseName);
		List<Subject> subjects = subjectRepository.findAllByCourse(course) ;
		return subjects;
	}
}
