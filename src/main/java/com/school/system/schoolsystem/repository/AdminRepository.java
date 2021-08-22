package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByFirstName(String firstName);
    Optional<Admin> findByEmail(String email);
}
