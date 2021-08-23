package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    Parent createParent(ParentDto parentDto,  Long adminId);
    Parent updateParentInfo(Long parentId, ParentDto parentDto);
    List<Parent> getAllParents();
    Optional<Parent> getAParent(Long parentId);
    Optional<Parent> getParentByName(String parentName);
    void deleteParent(Long parentId);
}
