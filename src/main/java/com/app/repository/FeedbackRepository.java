package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Feedback;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.entity.projection.FeedbackList;



public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findBySubjectId(Long subjectId);

	Feedback findByStudentAndSubject(Student student, Subject subject);

	@Query("Select new com.app.entity.projection.FeedbackList(f.student.id as studentId, f.knowledge as knowledge, f.communication as communication, f.punctuality as punctuality, f.teaching as teaching, f.guidance as guidance, f.suggestion as suggestion) from Feedback f join f.subject sb join f.student st where sb.subjectName =:subjectName order by st.id")
	List<FeedbackList> findAllBySubjectNameAndSortedById(@Param("subjectName") String subjectName);
}
