package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.UserException;
import com.school.system.schoolsystem.model.*;
import com.school.system.schoolsystem.repository.AdminRepository;
import com.school.system.schoolsystem.repository.ParentRepository;
import com.school.system.schoolsystem.repository.StudentRepository;
import com.school.system.schoolsystem.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices, UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Admin registerAdmin(AdminDto adminDto) throws UserException {
        Admin admin = new Admin();
        Optional<Admin> optionalAdminEmail = adminRepository.findByEmail(admin.getEmail());
        if (optionalAdminEmail.isPresent()){
            throw new UserException("Admin with email already exist");
        }else {
            modelMapper.map(adminDto, admin);
            admin.setRole(Role.ADMIN);
            admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
            return adminRepository.save(admin);
        }

    }

    @Override
    public Parent registerParent(ParentDto parentDto, Long studentId) throws UserException {

        Parent parent = new Parent();
        Optional<Parent> optionalParent = parentRepository.findByEmail(parent.getEmail());
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalParent.isPresent() || optionalStudent.isEmpty()) {
            throw new UserException("Parent with email already exist or Student with id doesn't exist");
        } else {
            modelMapper.map(parentDto, parent);
            Student student = optionalStudent.get();
            parent.addStudent(student);
            parent.setRole(Role.PARENT);
            parent.setPassword(passwordEncoder.encode(parentDto.getPassword()));
            return parentRepository.save(parent);
        }
    }

    @Override
    public Student registerStudent(StudentDto studentDto) throws UserException{
        Student student = new Student();
        Optional<Student> optionalStudent = studentRepository.findByEmail(student.getEmail());

        if (optionalStudent.isPresent()){
            throw new UserException("Student with email already exist");
        }else {
            modelMapper.map(studentDto, student);
            student.setRole(Role.STUDENT);
            student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
            return studentRepository.save(student);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (adminRepository.findByEmail(email).isPresent()){
            return adminRepository.findByEmail(email).get();
        }else if (studentRepository.findByEmail(email).isPresent()){
            return studentRepository.findByEmail(email).get();
        }else if (parentRepository.findByEmail(email).isPresent()){
            return parentRepository.findByEmail(email).get();
        }else if (teacherRepository.findByEmail(email).isPresent()){
            return teacherRepository.findByEmail(email).get();
        }
        throw new UsernameNotFoundException("Username or email not correct");
    }
}
