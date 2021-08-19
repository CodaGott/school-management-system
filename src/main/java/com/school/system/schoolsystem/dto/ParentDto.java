package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Address;
import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.model.Student;
import lombok.Data;

import java.util.List;
@Data
public class ParentDto {
    private String firstName;
    private String lastName;
    private List<Student> students;
    private Role role;
    private String email;
    private Address address;
}
