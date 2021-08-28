package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.exception.ParentException;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.repository.ParentRepository;
import com.school.system.schoolsystem.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ParentServiceImpl implements ParentService{

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ParentServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Parent createParent(ParentDto parentDto, Long studentId) throws ParentException {
        Parent parent = new Parent();

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()){
            modelMapper.map(parentDto, parent);
            Student student = optionalStudent.get();
            parent.addStudent(student);
            return parentRepository.save(parent);
        }else {
            throw new ParentException("Student with " + studentId + " does not exist");
        }
    }

    @Override
    public Parent updateParentInfo(ParentDto parentDto, Long parentId) throws ParentException {
        Parent parentToUpdate = parentRepository.findById(parentId).orElseThrow(
                () -> new ParentException("Parent with " +parentId + " id not found"));
        modelMapper.map(parentDto, parentToUpdate);
        return parentRepository.save(parentToUpdate);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getAParent(Long parentId) throws ParentException {
        return parentRepository.findById(parentId).orElseThrow(
                () -> new ParentException("Parent with " +parentId + " id not found"));
    }

    @Override
    public Parent getParentByName(String parentName) throws ParentException {
        return parentRepository.findByFirstName(parentName).orElseThrow(
                () -> new ParentException("Parent with " + parentName + " id not found"));
    }

    @Override
    public void deleteParent(Long parentId) throws ParentException {
        Parent parent = parentRepository.findById(parentId).orElseThrow(
                () -> new ParentException("Parent with " +parentId + " id not found"));
        parentRepository.delete(parent);
    }
}
