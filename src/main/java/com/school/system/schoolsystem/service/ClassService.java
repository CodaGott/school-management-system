package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    ClassRoom createClass(ClassDto classDto) throws ClassException;
    ClassRoom getAClass(Long classId) throws ClassException;
    ClassRoom updateClassInfo(ClassDto classDto, Long classId) throws ClassException;
    List<ClassRoom> getAllClasses();
    void deleteClass(Long classId) throws ClassException;
    Optional<ClassRoom> getAClassByName(String className) throws ClassException;
    void addStudentToClass(Long studentId, Long classId)throws ClassException;
    void addCourseToClass(Long courseId, Long classId)throws ClassException;
    void addTeacherToClass(Long teacherId, Long classId)throws ClassException;
    void removeStudentFromClass(Long studentId, Long classId)throws ClassException;
    void removeTeacherFromClass(Long teacherId, Long classId)throws ClassException;
    void removeCourseFromClass(Long courseId, Long classId)throws ClassException;
}
