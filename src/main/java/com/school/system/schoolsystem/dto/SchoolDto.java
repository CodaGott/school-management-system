package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Address;
import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Student;
import lombok.Data;

import java.util.List;
@Data
public class SchoolDto {
    private String name;
    private String description;
    private String founded;
    private List<Address> addresses;
    private List<Course> courses;
    private List<Student> students;
}
