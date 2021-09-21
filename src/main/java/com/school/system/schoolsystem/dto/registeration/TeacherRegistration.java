package com.school.system.schoolsystem.dto.registeration;

import com.school.system.schoolsystem.model.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Data
public class TeacherRegistration {
    @NotNull(message = "first name can't be null")
    private String firstName;
    @NotNull(message = "last name can't be null")
    private String lastName;
    @NotNull(message = "age can't be null")
    private Integer age;
    @NotNull(message = "email can't be null")
    @Email(message = "email must be valid")
    private String email;
    private String password;
    private Role role;
}
