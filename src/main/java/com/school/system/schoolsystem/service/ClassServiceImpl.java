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
    public Optional<ClassRoom> getAClass(Long classId) {
        return Optional.empty();
    }

    @Override
    public Optional<ClassRoom> updateClassInfo(Long classId, ClassDto classDto) {
        return Optional.empty();
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return null;
    }

    @Override
    public void deleteClass(Long classId) {

    }

    @Override
    public Optional<ClassRoom> getAClassByName(String className) {
        return Optional.empty();
    }
}
