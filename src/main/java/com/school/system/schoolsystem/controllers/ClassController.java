package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;


    @PostMapping("/createClass")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createClass(@RequestBody ClassDto classDto) throws ClassException{
        try {
            return new ResponseEntity<>(classService.createClass(classDto), HttpStatus.CREATED);
        } catch (ClassException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> getAllClasses(){
        return new ResponseEntity<>(classService.getAllClasses(), HttpStatus.FOUND);
    }

    @GetMapping("/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> getClassById(@PathVariable Long classId){
        try {
            return new ResponseEntity<>(classService.getAClass(classId), HttpStatus.FOUND);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{className}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> getClassByName(@PathVariable String className){
        try {
            return new ResponseEntity<>(classService.getAClassByName(className), HttpStatus.FOUND);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> updateClassInfo(@RequestBody ClassDto classDto, @PathVariable Long classId){
        try {
            return new ResponseEntity<>(classService.updateClassInfo(classDto, classId), HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete-class/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> deleteClass(@PathVariable Long classId) throws ClassException {
        try {
            classService.deleteClass(classId);
            return new ResponseEntity<>("Class deleted successfully", HttpStatus.NO_CONTENT);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/add/{studentId}/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> addStudentToClass(@PathVariable Long studentId, @PathVariable Long classId){
        try {
            classService.addStudentToClass(studentId, classId);
            return new ResponseEntity<>("Student added to class", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/add-course-to-class/{courseId}/{classId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addCourseToClass(@PathVariable Long courseId, @PathVariable Long classId){
        try {
            classService.addCourseToClass(courseId, classId);
            return new ResponseEntity<>("Course added successfully to class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/add-teacher-to-class/{teacherId}/{classId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addTeacherToClass(@PathVariable Long teacherId, @PathVariable Long classId){
        try {
            classService.addTeacherToClass(teacherId, classId);
            return new ResponseEntity<>("Teacher added successfully to class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/remove-student-from-class/{studentId}/{classId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> removeStudentFromClass(@PathVariable Long studentId, @PathVariable Long classId){
        try {
            classService.removeStudentFromClass(studentId, classId);
            return new ResponseEntity<>("Student removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/remove-teacher-from-class/{teacherId}/{classId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> removeTeacherFromClass(@PathVariable Long teacherId, @PathVariable Long classId){
        try {
            classService.removeTeacherFromClass(teacherId, classId);
            return new ResponseEntity<>("Teacher removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/remove-course-from-class/{courseId}/{classId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> removeCourseFromClass(@PathVariable Long courseId, @PathVariable Long classId){
        try {
            classService.removeCourseFromClass(courseId, classId);
            return new ResponseEntity<>("Course removed successfully from class room", HttpStatus.ACCEPTED);
        }catch (ClassException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
