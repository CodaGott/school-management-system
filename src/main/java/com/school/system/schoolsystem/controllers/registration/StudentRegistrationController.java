package com.school.system.schoolsystem.controllers.registration;

import com.school.system.schoolsystem.dto.registeration.StudentRegistration;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/registration")
    public ResponseEntity<?> studentRegister(@RequestBody StudentRegistration form){
        try {
            return new ResponseEntity<>(studentService.register(form), HttpStatus.CREATED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
