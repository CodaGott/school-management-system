package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDto courseDto, Long teacherId) throws CourseException;
    Course updateCourseInfo(CourseDto courseDto, Long courseId) throws CourseException;
    List<Course> getAllCourse() throws CourseException;
    Course getACourse(Long courseId) throws CourseException;
    Course getACourseByName(String courseName) throws CourseException;
    void deleteCourse(Long id) throws CourseException;
    void addStudentToCourse(Long studentId, Long courseId);
    void removeStudentFromCourse(Long studentId, Long courseId);
}
