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
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Student> students;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String password;
    private String phoneNumber;
    @Embedded
    private Address address;

    public void addStudent(Student... student){
        if (students == null){
            this.students = new ArrayList<>();
        }
        this.students.addAll(Arrays.asList(student));
    }
}
