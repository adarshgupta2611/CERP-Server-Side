package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Attendance;
import com.app.entity.projection.AttendanceRecord;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{
	@Query("SELECT new com.app.entity.projection.AttendanceRecord(a.attendance as attendance, s.subjectName as subjectName) FROM Attendance a JOIN a.subject s where a.student.id = :studentId")
	List<AttendanceRecord> findAttendanceByStudent(@Param("studentId") Long studentId);
}
