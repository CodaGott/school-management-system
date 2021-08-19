package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
