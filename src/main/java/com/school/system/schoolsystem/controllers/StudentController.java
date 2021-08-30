package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
        try {
            return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStudents(){
        try {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId){
        try {
            return new ResponseEntity<>(studentService.getAStudent(studentId), HttpStatus.FOUND);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<?> getStudentWithFirstName(@PathVariable String firstName) {
        try {
            return new ResponseEntity<>(studentService.getStudentByName(firstName), HttpStatus.FOUND);
        } catch (StudentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{studentId}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId){
        try {
            return new ResponseEntity<>(studentService.updateStudentInfo(studentDto, studentId), HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        try {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
