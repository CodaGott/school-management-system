package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService{
    @Override
    public Parent createParent(ParentDto parentDto) {
        return null;
    }

    @Override
    public Parent updateParentInfo(Long parentId, ParentDto parentDto) {
        return null;
    }

    @Override
    public List<Parent> getAllParents() {
        return null;
    }

    @Override
    public Parent getAParent(Long parentId) {
        return null;
    }

    @Override
    public Parent getParentByName(String parentName) {
        return null;
    }

    @Override
    public void deleteParent(Long parentId) {

    }
}
