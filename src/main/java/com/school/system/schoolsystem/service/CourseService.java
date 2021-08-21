package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Long teacherId, CourseDto courseDto);
    Course updateCourseInfo(Long courseId, CourseDto courseDto);
    List<Course> getAllCourse();
    Course getACourse(Long courseId);
    Course getACourseByName(String courseName);
    void deleteCourse(Long id);
}
