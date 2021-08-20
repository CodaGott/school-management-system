package com.school.system.schoolsystem.model;

import com.school.system.schoolsystem.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentTest {

    @Autowired
    private ParentRepository parentRepository;

    @Test
    void parentCanBeCreated(){
        Parent parent = new Parent();

        parent.setFirstName("John");
        parent.setLastName("Doe");
        parentRepository.save(parent);

        assertEquals(parent.getFirstName(), "John");
    }


    @Test
    void parentCanBeFetched(){
        Parent parent = parentRepository.findById(5L).orElseThrow();
        assertEquals(parent.getFirstName(), "John");
    }

    @Test
    void parentInfoCanBeUpdated(){
        Parent parent = parentRepository.findById(5L).orElseThrow();
        parent.setEmail("jonny@email.com");
        parentRepository.save(parent);
        assertEquals(parent.getEmail(), "jonny@email.com");
    }

    @Test
    void parentCanBeDeleted(){
        Parent parent = parentRepository.findById(5L).orElseThrow();
        parentRepository.delete(parent);
        assertEquals(parentRepository.findAll().size(), 0);
    }

}