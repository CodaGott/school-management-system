package com.school.system.schoolsystem.controllers.registration;

import com.school.system.schoolsystem.dto.registeration.AdminRegistration;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRegistrationController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody AdminRegistration form){
        try {
            return new ResponseEntity<>(adminService.register(form), HttpStatus.CREATED);
        }catch (AdminException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
