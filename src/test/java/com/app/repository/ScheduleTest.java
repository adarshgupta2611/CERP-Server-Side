package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Course;
import com.app.entities.Schedule;
import com.app.entities.Subject;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ScheduleTest {
	@Autowired
	SubjectRepository sbr;
	
	@Autowired
	CourseRepository cr;
	
	@Autowired
	ScheduleRepository sch;
	
	
	@Test
	void contextLoads() {
		
		List<Course> c = cr.findAll();
		Course c1 = c.get(0);
		Course c2 = c.get(1);
		
		List<Subject> sb = sbr.findAll();
		Subject sb1 = sb.get(0);
		Subject sb2 = sb.get(1);
		Subject sb3 = sb.get(2);
		Subject sb4 = sb.get(3);
		Subject sb5 = sb.get(4);
		Subject sb6 = sb.get(5);
		Subject sb7 = sb.get(6);
		Subject sb8 = sb.get(7);

		sch.saveAll(List.of(new Schedule(LocalDateTime.parse("2023-03-11T09:00:00"),LocalDateTime.parse("2023-03-11T12:00:00"),"Room 001",c1,sb1),
				new Schedule(LocalDateTime.parse("2023-03-11T13:00:00"),LocalDateTime.parse("2023-03-11T15:00:00"),"Room 001",c1,sb3)));
	}
}
