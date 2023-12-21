package com.app.repository;

import com.app.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	@Query("select new com.app.entity.projection.Schedule(sc.id as scheduleId, sc.startTime as startTime, sc.endTime as endTime, sc.location as location, sb.subjectName as subjectName) from Schedule sc join sc.subject sb where sc.course.courseName= :courseName")
	List<com.app.entity.projection.Schedule> findFullScheduleByCourse(@Param("courseName") String courseName);
}