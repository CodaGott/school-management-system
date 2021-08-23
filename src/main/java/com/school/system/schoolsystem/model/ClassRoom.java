package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Course> courses;
    @OneToMany
    private List<Teacher> teachers;


    public void addCourse(Course course){
        if (courses == null){
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
//        this.courses.addAll(Collections.singletonList(course));
//        this.courses.addAll(Arrays.asList(course));
    }

    public void addStudent(Student student){
        if (students == null){
            this.students = new ArrayList<>();
        }
//        this.students.add(student);
//        this.students.addAll(Arrays.asList(student));
        this.students.addAll(Collections.singletonList(student));
    }

    public void addTeacher(Teacher teacher){
        if (teachers == null){
            this.teachers = new ArrayList<>();
        }
//        this.teachers.add(teacher);
//        this.teachers.addAll(Collections.singletonList(teacher));
        this.teachers.addAll(Arrays.asList(teacher));
    }

}
