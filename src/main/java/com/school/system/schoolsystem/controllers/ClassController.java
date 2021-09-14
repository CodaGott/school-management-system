package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;


    @PostMapping("/createClass")
    public ResponseEntity<?> createClass(@RequestBody ClassDto classDto) throws ClassException{
        try {
            return new ResponseEntity<>(classService.createClass(classDto), HttpStatus.CREATED);
        } catch (ClassException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllClasses(){
        return new ResponseEntity<>(classService.getAllClasses(), HttpStatus.FOUND);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<?> getClassById(@PathVariable Long classId){
        try {
            return new ResponseEntity<>(classService.getAClass(classId), HttpStatus.FOUND);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{className}")
    public ResponseEntity<?> getClassByName(@PathVariable String className){
        try {
            return new ResponseEntity<>(classService.getAClassByName(className), HttpStatus.FOUND);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{classId}")
    public ResponseEntity<?> updateClassInfo(@RequestBody ClassDto classDto, @PathVariable Long classId){
        try {
            return new ResponseEntity<>(classService.updateClassInfo(classDto, classId), HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{classId}")
    public ResponseEntity<?> deleteClass(@PathVariable Long classId) throws ClassException {
        try {
            classService.deleteClass(classId);
            return new ResponseEntity<>("Class deleted successfully", HttpStatus.NO_CONTENT);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{studentId}/{classId}")
    public ResponseEntity<?> addStudentToClass(@PathVariable Long studentId, @PathVariable Long classId){
        try {
            classService.addStudentToClass(studentId, classId);
            return new ResponseEntity<>("Student added to class", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{courseId}/{classId}")
    public ResponseEntity<?> addCourseToClass(@PathVariable Long courseId, @PathVariable Long classId){
        try {
            classService.addCourseToClass(courseId, classId);
            return new ResponseEntity<>("Course added successfully to class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{teacherId}/{classId}")
    public ResponseEntity<?> addTeacherToClass(@PathVariable Long teacherId, @PathVariable Long classId){
        try {
            classService.addTeacherToClass(teacherId, classId);
            return new ResponseEntity<>("Teacher added successfully to class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{studentId}/{classId}")
    public ResponseEntity<?> removeStudentFromClass(@PathVariable Long studentId, @PathVariable Long classId){
        try {
            classService.removeStudentFromClass(studentId, classId);
            return new ResponseEntity<>("Student removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{teacherId}/{classId}")
    public ResponseEntity<?> removeTeacherFromClass(@PathVariable Long teacherId, @PathVariable Long classId){
        try {
            classService.removeTeacherFromClass(teacherId, classId);
            return new ResponseEntity<>("Teacher removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{courseId}/{classId}")
    public ResponseEntity<?> removeCourseFromClass(@PathVariable Long courseId, @PathVariable Long classId){
        try {
            classService.removeCourseFromClass(courseId, classId);
            return new ResponseEntity<>("Course removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
