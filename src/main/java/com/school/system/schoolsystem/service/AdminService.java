package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto) throws AdminException;
    Admin updateAdminInfo(AdminDto adminDto, Long adminId) throws AdminException;
    Optional<Admin> getAdmin(Long adminId);
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminByFirstName(String firstName);
    void deleteAdmin(Long adminId);
}
