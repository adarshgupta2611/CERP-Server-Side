package com.app.repository;

import com.app.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
	Course findByCourseName(String courseName);
}