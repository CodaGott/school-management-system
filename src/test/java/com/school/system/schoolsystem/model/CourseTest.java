package com.school.system.schoolsystem.model;

import com.school.system.schoolsystem.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseTest {


    @Autowired
    private CourseRepository courseRepository;

    @Test
    void courseCanBeCreated(){
        Course course = new Course();

        course.setName("English");
        course.setScore(90);
        course.setRemark("A student");
        courseRepository.save(course);

        assertEquals(course.getName(), "English");
    }

    @Test
    void testCourseCanBeFetched(){
        Course course = courseRepository.findById(6L).orElseThrow();
        assertEquals(course.getName(), "English");
    }

    @Test
    void testCourseInfoCanBeUpdated(){
        Course course = courseRepository.findById(6L).orElseThrow();
        course.setName("Java");
        courseRepository.save(course);
        assertEquals(course.getName(), "Java");
    }

    @Test
    void testCourseCanBeDeleted(){
        Course course = courseRepository.findById(6L).orElseThrow();
        courseRepository.delete(course);
        assertEquals(courseRepository.findAll().size(), 0);
    }

}