package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;

import java.util.List;

public interface ParentService {
    Parent createParent(ParentDto parentDto);
    Parent updateParentInfo(Long parentId, ParentDto parentDto);
    List<Parent> getAllParents();
    Parent getAParent(Long parentId);
    Parent getParentByName(String parentName);
    void deleteParent(Long parentId);
}
