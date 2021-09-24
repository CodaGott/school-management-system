package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.UserException;
import com.school.system.schoolsystem.model.Admin;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.model.Student;

public interface UserServices {

    Admin registerAdmin(AdminDto adminDto) throws UserException;
    Parent registerParent(ParentDto parentDto, Long studentId) throws UserException;
    Student registerStudent(StudentDto studentDto) throws UserException;

}
