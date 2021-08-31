package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto) throws StudentException;
    Student getAStudent(Long studentId) throws StudentException;
    List<Student> getAllStudents() throws StudentException;
    Student getStudentByName(String studentFirstName) throws StudentException;
    Student updateStudentInfo(StudentDto studentDto, Long studentId) throws StudentException;
    void deleteStudentById(Long studentId) throws StudentException;
    void addTeacherToStudent(Long teacherId, Long studentId);
    void addCourseToStudent(Long courseId, Long studentId);
}
