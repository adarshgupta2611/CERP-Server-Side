package com.app.repository;

import com.app.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmailAndPassword(String email, String password);

    Optional<Student> findByEmail(String email);

    List<Student> findAll();
}