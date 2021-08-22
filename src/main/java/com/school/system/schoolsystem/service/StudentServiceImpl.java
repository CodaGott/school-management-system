package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Override
    public Student createStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public Student getAStudent(Long studentId) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentByName(String studentFirstName) {
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
