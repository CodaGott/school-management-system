package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Override
    public Student createStudent(StudentDto studentDto , Long adminId) {
        return null;
    }

    @Override
    public Optional<Student> getAStudent(Long studentId) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
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
