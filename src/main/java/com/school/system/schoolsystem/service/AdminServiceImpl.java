package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.dto.registeration.AdminRegistration;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.model.Admin;
import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.repository.AdminRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public AdminServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


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
    public Admin register(AdminRegistration form) throws AdminException {
        Optional<Admin> optionalAdmin = adminRepository.findByEmail(form.getEmail());
        Admin admin = new Admin();

        if (optionalAdmin.isPresent()){
            throw new AdminException("Admin with email already exists");
        }
        modelMapper.map(form, admin);
        admin.setRole(Role.ADMIN);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdminInfo(AdminDto adminDto, Long adminId) throws AdminException{
        Admin adminToUpdate = adminRepository.findById(adminId).orElseThrow(
                () -> new AdminException("Can't find admin with " + adminId + " id"));
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
    public void deleteAdmin(Long adminId) throws AdminException {
        Admin admin = adminRepository.findById(adminId).orElseThrow(
                () -> new AdminException("Admin with id doesn't exist"));
            adminRepository.delete(admin);
    }
}
