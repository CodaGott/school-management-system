package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    Student getAStudent(Long studentId);
    List<Student> getAllStudents();
    Student getStudentByName(String studentFirstName);
    Student updateStudentInfo(Long studentId, StudentDto studentDto);
    void deleteStudentById(Long studentId);
}
