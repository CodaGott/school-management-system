package com.school.system.schoolsystem.repository;

import com.school.system.schoolsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
