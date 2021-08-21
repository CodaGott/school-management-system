package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.model.Student;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    Student getAStudent(Long studentId);
    Student getStudentByName(String studentFirstName);
    Student updateStudentInfo(Long studentId, StudentDto studentDto);
    void deleteStudentById(Long studentId);
}
