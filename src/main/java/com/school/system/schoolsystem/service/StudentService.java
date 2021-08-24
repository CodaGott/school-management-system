package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto , String studentEmail) throws StudentException, AdminException;
    Student getAStudent(Long studentId) throws StudentException;
    List<Student> getAllStudents();
    Student getStudentByName(String studentFirstName) throws StudentException;
    Student updateStudentInfo(Long studentId, StudentDto studentDto);
    void deleteStudentById(Long studentId) throws StudentException;
}
