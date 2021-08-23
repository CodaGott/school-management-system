package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.repository.ParentRepository;
import com.school.system.schoolsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Parent createParent(ParentDto parentDto, Long studentId) {



        return null;
    }

    @Override
    public Parent updateParentInfo(ParentDto parentDto, Long parentId) {
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
