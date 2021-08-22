package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.model.ClassRoom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{
    @Override
    public ClassRoom createClass(ClassDto classDto) {
        return null;
    }

    @Override
    public Optional<ClassRoom> getAClass(Long classId) {
        return Optional.empty();
    }

    @Override
    public Optional<ClassRoom> updateClassInfo(Long classId, ClassDto classDto) {
        return Optional.empty();
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return null;
    }

    @Override
    public void deleteClass(Long classId) {

    }

    @Override
    public Optional<ClassRoom> getAClassByName(String className) {
        return Optional.empty();
    }
}
