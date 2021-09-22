package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/addCourse/{teacherId}")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto, @PathVariable Long teacherId){
        try {
            return new ResponseEntity<>(courseService.createCourse(courseDto, teacherId), HttpStatus.CREATED);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCourses(){
        try {
            return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.FOUND);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId){
        try {
            return new ResponseEntity<>(courseService.getACourse(courseId), HttpStatus.FOUND);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("course/{name}")
    public ResponseEntity<?> getCourseByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(courseService.getACourseByName(name), HttpStatus.FOUND);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-course/{courseId}")
    public ResponseEntity<?> updateCourse(@RequestBody CourseDto courseDto, @PathVariable Long courseId){
        try {
            return new ResponseEntity<>(courseService.updateCourseInfo(courseDto, courseId), HttpStatus.ACCEPTED);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-course/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>("Course deleted successfully", HttpStatus.NO_CONTENT);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/add-student-to-course/{studentId}/{courseId}")
    public ResponseEntity<?> addStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        try {
            courseService.addStudentToCourse(studentId, courseId);
            return new ResponseEntity<>("Student added successfully", HttpStatus.ACCEPTED);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/remove-student-from-course/{studentId}/{courseId}")
    public ResponseEntity<?> removeStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        try {
            courseService.removeStudentFromCourse(studentId, courseId);
            return new ResponseEntity<>("Student removed successfully", HttpStatus.ACCEPTED);
        }catch (CourseException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
