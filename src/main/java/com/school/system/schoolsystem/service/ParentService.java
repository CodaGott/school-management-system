package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.exception.ParentException;
import com.school.system.schoolsystem.model.Parent;

import java.util.List;

public interface ParentService {
    Parent createParent(ParentDto parentDto, Long studentId) throws ParentException;
    Parent updateParentInfo(ParentDto parentDto, Long parentId);
    List<Parent> getAllParents();
    Parent getAParent(Long parentId) throws ParentException;
    Parent getParentByName(String parentName) throws ParentException;
    void deleteParent(Long parentId) throws ParentException;
}
