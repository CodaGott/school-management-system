package com.school.system.schoolsystem.model;

import com.school.system.schoolsystem.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void studentCanBeCreated(){
        Student student = new Student();

        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john@email.com");
        student.setRole(Role.STUDENT);
        studentRepository.save(student);

        assertEquals(student.getLastName(), "Doe");
    }

    @Test
    void studentCanBeFetched(){
        Student student = studentRepository.findById(4L).orElseThrow();
        assertEquals(student.getLastName(), "Doe");
    }

    @Test
    void studentInfoCanBeUpdate(){
        Student student = studentRepository.findById(4L).orElseThrow();
        student.setEmail("john.doe@email.com");
        studentRepository.save(student);
        assertEquals(student.getEmail(), "john.doe@email.com");
    }

    @Test
    void studentCanBeDeleted(){
        Student student = studentRepository.findById(4L).orElseThrow();
        studentRepository.delete(student);
        assertEquals(studentRepository.findAll().size(), 0);
    }

}