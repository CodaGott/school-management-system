package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private Address address;
    @OneToMany
    private List<Course> courses;
    @OneToMany
    private List<ClassRoom> classRooms;
    @OneToMany
    private List<Student> students;


    public void addStudent(Student student){
        if (students == null){
            this.students = new ArrayList<>();
        }
//        this.students.add(student);
//        this.students.addAll(Arrays.asList(student));
        this.students.addAll(Collections.singletonList(student));
    }

    public void addCourse(Course course){
        if (courses == null){
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
//        this.courses.addAll(Collections.singletonList(course));
//        this.courses.addAll(Arrays.asList(course));
    }

    public void addClass(ClassRoom classRoom){
        if (classRoom == null){
            this.classRooms = new ArrayList<>();
        }
        this.classRooms.add(classRoom);
//        this.classRooms.addAll(Arrays.asList(classRoom));
//        this.classRooms.addAll(Collections.singletonList(classRoom));
    }

}
