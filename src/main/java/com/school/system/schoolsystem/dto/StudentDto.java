package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.model.Teacher;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class StudentDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private Parent parent;
    private List<Course> courses;
    private List<Teacher> teachers;
    private Role role;
    private Map<Course, Integer> scores;
}
