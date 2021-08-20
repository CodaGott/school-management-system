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

    }
}