package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Override
    public Teacher createTeacher(TeacherDto teacherDto) {
        return null;
    }

    @Override
    public Teacher getATeacher(Long teacherId) {
        return null;
    }

    @Override
    public List<Teacher> getTeachers() {
        return null;
    }

    @Override
    public void deleteATeacher(Long teacherId) {

    }

    @Override
    public Teacher findATeacherByName(String teacherFirstName) {
        return null;
    }

    @Override
    public Teacher updateTeacherInfo(Long teacherId, TeacherDto teacherDto) {
        return null;
    }
}
