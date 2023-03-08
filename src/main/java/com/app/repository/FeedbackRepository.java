package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Feedback;
import com.app.entities.Student;
import com.app.entities.Subject;



public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findBySubjectId(Long subjectId);

	Feedback findByStudentAndSubject(Student student, Subject subject);
	
	@Query("Select rating from Feedback f where f.subject.subjectName=:subjectName")
	List<Integer> findAllBySubjectName(String subjectName);
}
