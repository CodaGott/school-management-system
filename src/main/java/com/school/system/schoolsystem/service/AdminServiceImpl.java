package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.model.Admin;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Override
    public Admin createAdmin(AdminDto adminDto) {
        return null;
    }

    @Override
    public Optional<Admin> updateAdminInfo(Long adminId) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> getAdmin(Long adminId) {
        return Optional.empty();
    }

    @Override
    public Admin getAllAdmins() {
        return null;
    }

    @Override
    public Admin getAdminByFirstName(String firstName) {
        return null;
    }

    @Override
    public void deleteAdmin(Long adminId) {

    }
}
