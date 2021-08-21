package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    ClassRoom createClass(ClassDto classDto);
    Optional<ClassRoom> getAClass(Long classId);
    Optional<ClassRoom> updateClassInfo(Long classId, ClassDto classDto);
    List<ClassRoom> getAllClasses();
    void deleteClass(Long classId);
    Optional<ClassRoom> getAClassByName(String className);
}
