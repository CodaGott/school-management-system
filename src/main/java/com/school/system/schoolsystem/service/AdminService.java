package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.model.Admin;

import java.util.Optional;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto);
    Optional<Admin> updateAdminInfo(Long adminId);
    Optional<Admin> getAdmin(Long adminId);
    Admin getAllAdmins();
    Admin getAdminByFirstName(String firstName);
    void deleteAdmin(Long adminId);
}
