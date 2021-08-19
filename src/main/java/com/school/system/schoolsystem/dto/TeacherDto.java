package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Class;
import com.school.system.schoolsystem.model.*;
import lombok.Data;

import java.util.List;
@Data
public class TeacherDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private Role role;
    private Address address;
    private List<Course> courses;
    private List<Class> classes;
    private List<Student> students;
}
