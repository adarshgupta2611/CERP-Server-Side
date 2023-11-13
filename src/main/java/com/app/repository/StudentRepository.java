package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>{
	Student findByEmailAndPassword(String email, String password);
	Optional<Student> findByEmail(String email);
}