package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;

public interface ParentService {
    Parent createParent(ParentDto parentDto);
    Parent updateParentInfo(Long parentId, ParentDto parentDto);
    Parent getAParent(Long parentId);
    Parent getParentByName(String parentName);
    void deleteParent(Long parentId);
}
