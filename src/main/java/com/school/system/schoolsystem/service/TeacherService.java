package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(TeacherDto teacherDto);
    Teacher getATeacher(Long teacherId);
    List<Teacher> getTeachers();
    void deleteATeacher(Long teacherId);
    Teacher findATeacherByName(String teacherFirstName);
    Teacher updateTeacherInfo(Long teacherId, TeacherDto teacherDto);

}
