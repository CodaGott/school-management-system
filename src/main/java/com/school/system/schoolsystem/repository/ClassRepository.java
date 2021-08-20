package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassRoom, Long> {
}
