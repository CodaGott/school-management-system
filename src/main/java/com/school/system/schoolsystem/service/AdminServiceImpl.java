package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.model.Admin;
import com.school.system.schoolsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public Admin createAdmin(AdminDto adminDto) {
        return null;
    }

    @Override
    public Admin updateAdminInfo(Long adminId) {
        return null;
    }

    @Override
    public Optional<Admin> getAdmin(Long adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminByFirstName(String firstName) {
        return adminRepository.findByFirstName(firstName);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Optional<Admin> admin = adminRepository.findById(adminId);
        if (admin.isPresent()){
            adminRepository.deleteById(adminId);
        }else {
            throw new NoSuchElementException("Admin with id doesn't exist");
        }

    }
}
