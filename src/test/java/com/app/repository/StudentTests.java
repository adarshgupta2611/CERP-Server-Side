package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Course;
import com.app.entities.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentTests {
	
	@Autowired
	CourseRepository cr;
	
	@Autowired
	StudentRepository sr;
	
    
	@Test
	void contextLoads() {
			
			List<Course> cs = cr.findAll();
			Course cs1 = cs.get(0);
			Course cs2 = cs.get(1);

		sr.saveAll(List.of(new Student("Disha", "Murarka","dishamurarka1117@gmail.com","Female", "Dish@111", "Pune", cs1),
				new Student("Rakshit", "Jain","rakshitjain@gmail.com","Male", "Rakshit@111", "Pune", cs2),
				new Student("Test","test","test@Test.com","Female","Test@789","Surat",cs1),
				new Student("Test1","test1","test1@Test.com","Male","Test@789","Surat",cs1)));
	}

}

/*
 this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.course = course; */
 