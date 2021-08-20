package com.school.system.schoolsystem.model;

import com.school.system.schoolsystem.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdminTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void adminCanBeCreated(){
        Admin admin = new Admin();

        admin.setFirstName("John");
        admin.setLastName("Does");
        admin.setEmail("John@email.com");
        admin.setRole(Role.ADMIN);
        adminRepository.save(admin);

        assertEquals(admin.getEmail(), "John@email.com");
    }

    @Test
    void adminCanBeFetched(){
        Admin admin = adminRepository.findById(3L).orElseThrow();

        assertEquals(admin.getLastName(), "Does");
    }

    @Test
    void adminInfoCanBeUpdated(){
        Admin admin = adminRepository.findById(3L).orElseThrow();
        admin.setLastName("Doe");
        adminRepository.save(admin);

        assertEquals(admin.getLastName(), "Doe");
    }

    @Test
    void adminCanBeDeleted(){
        Admin admin = adminRepository.findById(3L).orElseThrow();
        adminRepository.delete(admin);
        assertEquals(0, adminRepository.findAll().size());
    }
}