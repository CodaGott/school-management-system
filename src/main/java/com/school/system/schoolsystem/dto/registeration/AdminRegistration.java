package com.school.system.schoolsystem.dto.registeration;

import com.school.system.schoolsystem.model.Role;
import lombok.Data;

@Data
public class AdminRegistration {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
}
