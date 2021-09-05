package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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


    public void addCourse(Course... course){
        if (courses == null){
            this.courses = new ArrayList<>();
        }
        this.courses.addAll(Arrays.asList(course));
    }

    public void addStudent(Student... student){
        if (students == null){
            this.students = new ArrayList<>();
        }
        this.students.addAll(Arrays.asList(student));
    }

    public void addTeacher(Teacher... teacher){
        if (teachers == null){
            this.teachers = new ArrayList<>();
        }
        this.teachers.addAll(Arrays.asList(teacher));
    }

    public void removeTeacherFromClass(Teacher teacher){
        if (teachers == null){
            this.teachers = new ArrayList<>();
        }else {
            this.teachers.remove(teacher);
        }
    }

    public void removeStudentFromClass(Student student){
        if (students == null){
            this.students = new ArrayList<>();
        }else {
            this.students.remove(student);
        }
    }

    public void removeCourseFromClass(Course course){
        if (courses == null){
            this.courses = new ArrayList<>();
        }else {
            this.courses.remove(course);
        }
    }

}
