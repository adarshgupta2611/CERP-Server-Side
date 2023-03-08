package com.app.service;

import java.util.List;

import com.app.entities.Admin;
import com.app.entities.Course;
import com.app.entities.Subject;

public interface AdminService {
	Admin authenticateAdmin(String email, String password);
	List<Course> getCourseList();
	List<Subject> getSubjectList(String courseName);
}
