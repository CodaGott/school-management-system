package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.dto.registeration.AdminRegistration;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.model.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(AdminDto adminDto) throws AdminException;
    Admin register(AdminRegistration form) throws AdminException;
    Admin updateAdminInfo(AdminDto adminDto, Long adminId) throws AdminException;
    Admin getAdmin(Long adminId) throws AdminException;
    List<Admin> getAllAdmins();
    Admin getAdminByFirstName(String firstName) throws AdminException;
    void deleteAdmin(Long adminId) throws AdminException;
}
