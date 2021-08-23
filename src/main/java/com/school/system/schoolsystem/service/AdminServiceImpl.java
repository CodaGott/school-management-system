package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.model.Admin;
import com.school.system.schoolsystem.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Admin createAdmin(AdminDto adminDto) throws AdminException {
        Optional<Admin> optionalAdmin = adminRepository.findByEmail(adminDto.getEmail());
        Admin admin = new Admin();
        if (optionalAdmin.isPresent()){
            throw new AdminException("User with email already exists");
        }
        modelMapper.map(adminDto, admin);
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdminInfo(AdminDto adminDto, Long adminId) throws AdminException{
        Admin adminToUpdate = adminRepository.findById(adminId).orElseThrow(
                () -> new AdminException("Can't find admin with " + adminId + " id")
        );
        modelMapper.map(adminDto, adminToUpdate);
        return adminRepository.save(adminToUpdate);
    }

    @Override
    public Admin getAdmin(Long adminId) throws AdminException {
        return adminRepository.findById(adminId).orElseThrow(
                () -> new AdminException("Can't find admin with " + adminId + " id")
        );
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminByFirstName(String firstName) throws AdminException {
        return adminRepository.findByFirstName(firstName).orElseThrow(
                () -> new AdminException("Can't find admin with " + firstName + " as first name")
        );
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
