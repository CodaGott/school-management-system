package com.school.system.schoolsystem.controllers.registration;

import com.school.system.schoolsystem.dto.registeration.TeacherRegistration;
import com.school.system.schoolsystem.exception.TeacherException;
import com.school.system.schoolsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherRegistrationController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody TeacherRegistration form){
        try {
            return new ResponseEntity<>(teacherService.register(form), HttpStatus.CREATED);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
