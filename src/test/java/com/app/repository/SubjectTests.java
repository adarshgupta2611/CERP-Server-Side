package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Course;
import com.app.entities.Subject;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SubjectTests {
	@Autowired
	SubjectRepository sr;
	
	@Autowired
	CourseRepository cr;
	
	@Test
	void contextLoads() {
		List<Course> cs = cr.findAll();
		Course cs1 = cs.get(0);
		Course cs2 = cs.get(1);
		sr.saveAll(List.of(new Subject("Core Java", cs1),new Subject("DBT", cs1),new Subject("SDM", cs1),
		new Subject("DotNet", cs1),new Subject("DataAnalytics", cs2),new Subject("DataBase Technology", cs2),new Subject("Java", cs2),new Subject("Linux", cs2)));
	}

	//this.subjectName = subjectName;
}
