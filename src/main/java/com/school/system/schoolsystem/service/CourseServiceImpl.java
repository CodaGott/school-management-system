package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Override
    public Course createCourse(Long teacherId, CourseDto courseDto) {
        return null;
    }

    @Override
    public Course updateCourseInfo(Long courseId, CourseDto courseDto) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public Optional<Course> getACourse(Long courseId) {
        return Optional.empty();
    }

    @Override
    public Course getACourseByName(String courseName) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
