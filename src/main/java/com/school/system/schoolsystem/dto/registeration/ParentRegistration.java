package com.school.system.schoolsystem.dto.registeration;

import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.model.Student;
import lombok.Data;

import java.util.List;
@Data
public class ParentRegistration {
    private String firstName;
    private String lastName;
    private List<Student> students;
    private Role role;
    private String email;
    private String password;
    private String phoneNumber;
}
