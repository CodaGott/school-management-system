package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.dto.registeration.TeacherRegistration;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.exception.TeacherException;
import com.school.system.schoolsystem.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(TeacherDto teacherDto, Long adminId) throws TeacherException, CourseException;
    Teacher register(TeacherRegistration form) throws TeacherException;
    Teacher getATeacher(Long teacherId) throws TeacherException;
    List<Teacher> getTeachers() throws TeacherException;
    void deleteATeacher(Long teacherId) throws TeacherException;
    Teacher findATeacherByName(String teacherFirstName) throws TeacherException;
    Teacher updateTeacherInfo(TeacherDto teacherDto, Long teacherId ) throws TeacherException;
    void addClassToTeacher(Long classId, Long teacherId) throws TeacherException;
    void addStudentToTeacher(Long studentId, Long teacherId) throws TeacherException;
    void removeCourseFromTeacher(Long courseId, Long teacherId)throws TeacherException;
    void removeStudentFromTeacher(Long studentId, Long teacherId)throws TeacherException;

}
