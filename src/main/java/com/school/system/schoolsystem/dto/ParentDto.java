package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Address;
import com.school.system.schoolsystem.model.Role;
import com.school.system.schoolsystem.model.Student;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class ParentDto {
    @NotNull(message = "first name can't be null")
    private String firstName;
    @NotNull(message = "last name can't be null")
    private String lastName;
    private List<Student> students;
    private Role role;
    @NotNull(message = "email name can't be null")
    @Email(message = "email should be null")
    private String email;
    private String password;
    private Address address;
}
