package com.app.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Admin;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AdminTest {


	@Autowired
	AdminRepository ar;	
	
	@Test
	void contextLoads() {
		ar.saveAll(List.of(new Admin("adarsh@gmail.com", "Adarsh@111"),new Admin("nikita@gmail.com","Nikita@111")));

	}
}
