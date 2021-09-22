package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Optional<Parent> findByFirstName(String firstName);
    Optional<Parent> findByEmail(String email);
}
