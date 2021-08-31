package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.exception.TeacherException;
import com.school.system.schoolsystem.model.*;
import com.school.system.schoolsystem.repository.*;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;


    private ModelMapper modelMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public TeacherServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Teacher createTeacher(TeacherDto teacherDto, Long courseId) throws CourseException, TeacherException {
        Teacher teacher = new Teacher();

        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()){
            modelMapper.map(teacherDto, teacher);
            Course course = optionalCourse.get();
            teacher.addCourse(course);
            return teacherRepository.save(teacher);
        }else{
            throw new CourseException("Course with " + courseId + " id does not exist");
        }
    }

    @Override
    public Teacher getATeacher(Long teacherId) throws TeacherException {
//        return teacherRepository.findById(teacherId).orElseThrow(
//                () -> new TeacherException("Teacher with " + teacherId + " does not exist")
//        );

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isPresent()){
            return optionalTeacher.get();
        }else {
            throw new TeacherException("Teacher with " + teacherId + " does not exist");
        }
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteATeacher(Long teacherId) throws TeacherException {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new TeacherException("Teacher with " + teacherId + " does not exist"));
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findATeacherByName(String teacherFirstName) throws TeacherException {
        return teacherRepository.findByFirstName(teacherFirstName).orElseThrow(
                () -> new TeacherException("Teacher with " + teacherFirstName + " name does not exist")
        );
    }

    @Override
    public Teacher updateTeacherInfo(TeacherDto teacherDto, Long teacherId ) throws TeacherException {
//        Teacher teacherToUpdate = teacherRepository.getById(teacherId);
        Teacher teacherToUpdate = teacherRepository.findById(teacherId).orElseThrow(
                () -> new TeacherException("Teacher with " + teacherId + " does not exist")
        );
        modelMapper.map(teacherDto, teacherToUpdate);
        return teacherRepository.save(teacherToUpdate);
    }

    @Override
    public void addClassToTeacher(Long classId, Long teacherId) {

    }

    @Override
    public void addStudentToClass(Long studentId, Long teacherId) {

    }
}
