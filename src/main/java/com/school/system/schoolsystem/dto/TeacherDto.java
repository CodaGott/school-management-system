package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.ClassRoom;
import com.school.system.schoolsystem.model.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class TeacherDto {
    @NotNull(message = "first name can't be null")
    private String firstName;
    @NotNull(message = "last name can't be null")
    private String lastName;
    @NotNull(message = "age can't be null")
    private Integer age;
    @NotNull(message = "email can't be null")
    @Email(message = "email must be valid")
    private String email;
    private Role role;
    private Address address;
    private List<Course> courses;
    private List<ClassRoom> classRooms;
    private List<Student> students;
}
