package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    @OneToOne
    private Parent parent;
    @OneToMany
    private List<Course> courses;
    @OneToMany
    private List<Teacher> teachers;
    @OneToOne
    private Class Class;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private Address address;

    private Map<Course, Integer> scores;
}
