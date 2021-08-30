package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.exception.ParentException;
import com.school.system.schoolsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/register/{studentId}")
    public ResponseEntity<?> createParent(@RequestBody ParentDto parentDto, @PathVariable Long studentId){
        try {
            return new ResponseEntity<>(parentService.createParent(parentDto, studentId), HttpStatus.CREATED);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllParents(){
        try {
            return new ResponseEntity<>(parentService.getAllParents(), HttpStatus.FOUND);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<?> getParentById(@PathVariable Long parentId){
        try {
            return new ResponseEntity<>(parentService.getAParent(parentId), HttpStatus.FOUND);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<?> getParentByFirstName(@PathVariable String firstName){
        try {
            return new ResponseEntity<>(parentService.getParentByName(firstName), HttpStatus.FOUND);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{parentId}")
    public ResponseEntity<?> updateParentInfo(@RequestBody ParentDto parentDto, @PathVariable Long parentId){
        try {
            return new ResponseEntity<>(parentService.updateParentInfo(parentDto, parentId), HttpStatus.ACCEPTED);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{parentId}")
    public ResponseEntity<?> deleteParent(@PathVariable Long parentId){
        try {
            parentService.deleteParent(parentId);
            return new ResponseEntity<>("Parent deleted successfully", HttpStatus.NO_CONTENT);
        }catch (ParentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
