package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.repository.AdminRepository;
import com.school.system.schoolsystem.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Student createStudent(StudentDto studentDto , Long adminId) throws StudentException, AdminException {
        Student student = new Student();

        boolean adminExist = adminRepository.findById(adminId).isPresent();
        if (adminExist){
            throw new AdminException("Admin with id does not exist");
        }

        boolean studentExists = studentRepository.findByEmail(student.getEmail()).isPresent();

        if (studentExists){
            throw new StudentException("Student with email already exists");
        }
        modelMapper.map(studentDto, student);
//        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getAStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentByName(String studentFirstName) {
        return null;
    }

    @Override
    public Student updateStudentInfo(Long studentId, StudentDto studentDto) {
        return null;
    }

    @Override
    public void deleteStudentById(Long studentId) {

    }
}
