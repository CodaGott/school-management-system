package com.school.system.schoolsystem.model;

import com.school.system.schoolsystem.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TeacherTest {


    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    void teacherCanBeCreated(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setEmail("john@email.com");
        teacher.setRole(Role.TEACHER);
        teacherRepository.save(teacher);

        assertEquals(teacher.getFirstName(), "John");
    }

    @Test
    void teacherInfoCanBeFetched(){
        Teacher teacher = teacherRepository.findById(1L).orElseThrow();
        assertEquals(teacher.getFirstName(), "John");
    }
}