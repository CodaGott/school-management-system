package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.model.Teacher;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class ClassDto {
    @NotNull(message = "name can't be null")
    private String name;
    private List<Student> students;
    private List<Course> courses;
    private List<Teacher> teachers;
}
