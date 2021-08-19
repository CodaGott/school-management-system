package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
}
