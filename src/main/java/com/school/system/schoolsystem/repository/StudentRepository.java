package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
