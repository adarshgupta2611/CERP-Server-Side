package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Attendance;
import com.app.entities.Student;
import com.app.entities.Subject;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AttendanceTests {
	@Autowired
	SubjectRepository sbr;
	
	@Autowired
	AttendanceRepository ar;
	
	@Autowired
	StudentRepository sr;
	
	
	@Test
	void contextLoads() {
		
		List<Student> s = sr.findAll();
		Student s1 = s.get(0);
		Student s2 = s.get(1);
		
		List<Subject> sb = sbr.findAll();
		Subject sb1 = sb.get(0);
		Subject sb2 = sb.get(1);
		Subject sb3 = sb.get(2);
		Subject sb4 = sb.get(3);
		Subject sb5 = sb.get(4);
		Subject sb6 = sb.get(5);
		Subject sb7 = sb.get(6);
		Subject sb8 = sb.get(7);

		ar.saveAll(List.of(new Attendance(80, sb1, s1),new Attendance(90, sb2, s1),new Attendance(85, sb3, s1), new Attendance(70, sb4, s1),
				new Attendance(100, sb5, s2),new Attendance(80, sb6, s2),new Attendance(75, sb7, s2), new Attendance(95, sb8, s2)));
	}

}
/*
this.attendance = attendance;
		this.subject = subject;
		this.student = student;

*/