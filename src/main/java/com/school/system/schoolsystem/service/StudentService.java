package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(StudentDto studentDto , Long adminId) throws StudentException, AdminException;
    Optional<Student> getAStudent(Long studentId);
    List<Student> getAllStudents();
    Optional<Student> getStudentByName(String studentFirstName);
    Student updateStudentInfo(Long studentId, StudentDto studentDto);
    void deleteStudentById(Long studentId);
}
