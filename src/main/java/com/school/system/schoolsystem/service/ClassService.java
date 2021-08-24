package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    ClassRoom createClass(ClassDto classDto, String name) throws ClassException;
    ClassRoom getAClass(Long classId);
    ClassRoom updateClassInfo(ClassDto classDto, Long classId);
    List<ClassRoom> getAllClasses();
    void deleteClass(Long classId) throws ClassException;
    Optional<ClassRoom> getAClassByName(String className);
}
