package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.model.Teacher;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
@Data
public class StudentDto {
    @NotNull(message = "first name can't be null")
    private String firstName;
    @NotNull(message = "last name can't be null")
    private String lastName;
    @NotNull(message = "age name can't be null")
    private Integer age;
    @NotNull(message = "email can't be null")
    @Email(message = "email must be valid")
    private String email;
    @NotNull(message = "Student must have guardian")
    private Parent parent;
    private List<Course> courses;
    private List<Teacher> teachers;
    private Role role;
    private Map<Course, Integer> scores;
}
