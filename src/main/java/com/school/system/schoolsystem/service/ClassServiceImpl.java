package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;
import com.school.system.schoolsystem.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ClassRoom createClass(ClassDto classDto, String className) throws ClassException {
        ClassRoom classRoom = new ClassRoom();

        boolean classExists = classRepository.findByName(classRoom.getName()).isPresent();

        if (classExists){
            throw new ClassException("Class with name already exists");
        }
        modelMapper.map(classDto, classRoom);

        return classRepository.save(classRoom);
    }

    @Override
    public ClassRoom getAClass(Long classId) {
        return classRepository.findById(classId).orElseThrow(
                () -> new ClassCastException("Class with " + classId + " id does not exist"));
    }

    @Override
    public ClassRoom updateClassInfo(ClassDto classDto, Long classId) {
        ClassRoom classToUpdate = classRepository.getById(classId);
            modelMapper.map(classDto, classToUpdate);
        return classRepository.save(classToUpdate);
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public void deleteClass(Long classId) throws ClassException {
        ClassRoom classToDelete = classRepository.findById(classId).orElseThrow(
                () -> new ClassException("Class with " + classId + " id does not exist"));
        classRepository.delete(classToDelete);
    }

    @Override
    public Optional<ClassRoom> getAClassByName(String className) {
        Optional<ClassRoom> classNameExists = classRepository.findByName(className);
        if (classNameExists.isPresent()){
            return classRepository.findByName(className);
        }else {
            throw new ClassCastException("Class with name " + className + " does not exist");
        }

    }
}
