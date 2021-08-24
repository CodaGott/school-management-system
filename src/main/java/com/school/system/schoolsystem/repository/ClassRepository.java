package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<ClassRoom, Long> {

    Optional<ClassRoom> findByName(String className);
}
