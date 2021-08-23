package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Override
    public Teacher createTeacher(TeacherDto teacherDto, Long adminId) {
        return null;
    }

    @Override
    public Optional<Teacher> getATeacher(Long teacherId) {
        return Optional.empty();
    }

    @Override
    public List<Teacher> getTeachers() {
        return null;
    }

    @Override
    public void deleteATeacher(Long teacherId) {

    }

    @Override
    public Optional<Teacher> findATeacherByName(String teacherFirstName) {
        return Optional.empty();
    }

    @Override
    public Teacher updateTeacherInfo(Long teacherId, TeacherDto teacherDto) {
        return null;
    }
}
