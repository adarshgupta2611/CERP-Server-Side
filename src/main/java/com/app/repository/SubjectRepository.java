package com.app.repository;

import com.app.entities.Course;
import com.app.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
	Subject findBySubjectName(String name);
	List<Subject> findAllByCourse(Course course);
}