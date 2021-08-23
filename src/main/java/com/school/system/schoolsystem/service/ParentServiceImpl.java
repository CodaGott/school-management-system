package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    @Override
    public Parent createParent(ParentDto parentDto, Long adminId) {
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
    public Optional<Parent> getAParent(Long parentId) {
        return Optional.empty();
    }

    @Override
    public Optional<Parent> getParentByName(String parentName) {
        return Optional.empty();
    }

    @Override
    public void deleteParent(Long parentId) {

    }
}
