package com.school.system.schoolsystem.controllers;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> getAllStudents(){
        try {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-by-id/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PARENT', 'TEACHER', 'STUDENT')")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId){
        try {
            return new ResponseEntity<>(studentService.getAStudent(studentId), HttpStatus.FOUND);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-by-name/{firstName}")
    public ResponseEntity<?> getStudentWithFirstName(@PathVariable String firstName) {
        try {
            return new ResponseEntity<>(studentService.getStudentByName(firstName), HttpStatus.FOUND);
        } catch (StudentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId){
        try {
            return new ResponseEntity<>(studentService.updateStudentInfo(studentDto, studentId), HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-student/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        try {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/add-teacher-to-student/{teacherId}/{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addTeacherToStudent(@PathVariable Long teacherId, @PathVariable Long studentId) {
        try {
            studentService.addTeacherToStudent(teacherId, studentId);
            return new ResponseEntity<>("Teacher added successfully", HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/add-course-to-student/{courseId}/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> addCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        try {
            studentService.addCourseToStudent(courseId, studentId);
            return new ResponseEntity<>("Course added successfully", HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/remove-course-from-student/{courseId}/{studentId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<?> removeCourseFromStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        try {
            studentService.removeCourseFromStudent(courseId, studentId);
            return new ResponseEntity<>("Course removed Course From Student", HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/remove-teacher-from-student/{teacherId}/{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> removeTeacherFromStudent(@PathVariable Long teacherId, @PathVariable Long studentId){
        try{
            studentService.removeTeacherFromStudent(teacherId, studentId);
            return new ResponseEntity<>("Teacher removed from student", HttpStatus.ACCEPTED);
        }catch (StudentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
