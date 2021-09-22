package com.school.system.schoolsystem.controllers.registration;

import com.school.system.schoolsystem.dto.registeration.ParentRegistration;
import com.school.system.schoolsystem.exception.ParentException;
import com.school.system.schoolsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentRegistrationController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ParentRegistration form){
        try {
            return new ResponseEntity<>(parentService.register(form), HttpStatus.CREATED);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
