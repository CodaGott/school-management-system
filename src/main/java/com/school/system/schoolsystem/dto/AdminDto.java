package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Address;
import com.school.system.schoolsystem.model.Role;
import lombok.Data;

@Data
public class AdminDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private Role role;
    private Address address;
}
