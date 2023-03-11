package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Attendance;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.entity.projection.AttendanceList;
import com.app.entity.projection.AttendanceRecord;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
	@Query("SELECT new com.app.entity.projection.AttendanceRecord(a.attendance as attendance, s.subjectName as subjectName, st.firstName as firstName, st.lastName as lastName, st.email as email, st.gender as gender, st.address as address, st.course as course) FROM Attendance a JOIN a.subject s JOIN a.student st  where a.student.id = :studentId")
	List<AttendanceRecord> findAttendanceByStudent(@Param("studentId") Long studentId);

	@Query("Select new com.app.entity.projection.AttendanceList(a.student as student, a.attendance as attendance) from Attendance a join a.student s join a.subject sb where a.subject.subjectName=:subjectName ORDER BY s.id")
	List<AttendanceList> findAllBySubjectNameAndSortedById(@Param("subjectName") String subjectName);

	Attendance findAttendanceByStudentAndSubject(Student student, Subject subject);
}