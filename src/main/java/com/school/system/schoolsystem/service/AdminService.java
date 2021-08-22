package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto);
    Admin updateAdminInfo(Long adminId);
    Optional<Admin> getAdmin(Long adminId);
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminByFirstName(String firstName);
    void deleteAdmin(Long adminId);
}
