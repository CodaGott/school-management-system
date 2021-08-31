package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;
import com.school.system.schoolsystem.repository.ClassRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClassServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public ClassRoom createClass(ClassDto classDto) throws ClassException {
        ClassRoom classRoom = new ClassRoom();

//        Optional<ClassRoom> optionalClassRoom = classRepository.findByName(classDto.getName());

        boolean classExists = classRepository.findByName(classDto.getName()).isPresent();

        if (classExists){
            throw new ClassException("Class with name already exists");
        }
        modelMapper.map(classDto, classRoom);

        return classRepository.save(classRoom);
    }

    @Override
    public ClassRoom getAClass(Long classId) throws ClassException {
        return classRepository.findById(classId).orElseThrow(
                () -> new ClassException("Class with " + classId + " id does not exist"));
    }

    @Override
    public ClassRoom updateClassInfo(ClassDto classDto, Long classId) throws ClassException {
        ClassRoom classToUpdate = classRepository.findById(classId).orElseThrow(
                () -> new ClassException("Teacher with " + classId + " does not exist"));

//        Course course = new Course();
//        classToUpdate.addCourse(course);
//
//        Student student = new Student();
//        classToUpdate.addStudent(student);
//
//        Teacher teacher = new Teacher();
//        classToUpdate.addTeacher(teacher);

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

    @Override
    public void addStudentToClass(Long studentId, Long classId) {

    }

    @Override
    public void addCourseToClass(Long courseId, Long classId) {

    }

    @Override
    public void addTeacherToClass(Long teacherId, Long classId) {

    }
}
