package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByEmailAndPassword(String email, String password);
	Optional<Admin> findByEmail(String email);
}