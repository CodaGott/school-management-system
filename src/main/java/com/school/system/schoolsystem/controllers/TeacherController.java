package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.exception.TeacherException;
import com.school.system.schoolsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/register/{courseId}")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long courseId){
        try {
            return new ResponseEntity<>(teacherService.createTeacher(teacherDto, courseId), HttpStatus.CREATED);
        }catch (TeacherException | CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTeachers(){
        try {
            return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.FOUND);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<?> getTeacherWithId(@PathVariable Long teacherId){
        try {
            return new ResponseEntity<>(teacherService.getATeacher(teacherId), HttpStatus.FOUND);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<?> getTeacherByFirstName(@PathVariable String firstName){
        try {
            return new ResponseEntity<>(teacherService.findATeacherByName(firstName), HttpStatus.FOUND);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacherInfo(@RequestBody TeacherDto teacherDto, @PathVariable Long teacherId){
        try {
            return new ResponseEntity<>(teacherService.updateTeacherInfo(teacherDto, teacherId), HttpStatus.ACCEPTED);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long teacherId){
        try {
            teacherService.deleteATeacher(teacherId);
            return new ResponseEntity<>("Teacher deleted successfully", HttpStatus.NO_CONTENT);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{studentId}/{teacherId}")
    public ResponseEntity<?> addAStudent(@PathVariable Long studentId, @PathVariable Long teacherId){
        try {
            teacherService.addStudentToTeacher(studentId, teacherId);
            return new ResponseEntity<>("Student added successfully!", HttpStatus.ACCEPTED);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{classId}/{teacherId}")
    public ResponseEntity<?> addClass(@PathVariable Long classId, @PathVariable Long teacherId){
        try {
            teacherService.addClassToTeacher(classId, teacherId);
            return new ResponseEntity<>("Class added successfully!", HttpStatus.ACCEPTED);
        }catch (TeacherException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
