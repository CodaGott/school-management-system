package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    ClassRoom createClass(ClassDto classDto, String name) throws ClassException);
    Optional<ClassRoom> getAClass(Long classId);
    Optional<ClassRoom> updateClassInfo(Long classId, ClassDto classDto);
    List<ClassRoom> getAllClasses();
    void deleteClass(Long classId);
    Optional<ClassRoom> getAClassByName(String className);
}
