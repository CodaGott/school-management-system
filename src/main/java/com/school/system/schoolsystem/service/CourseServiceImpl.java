package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Teacher;
import com.school.system.schoolsystem.repository.CourseRepository;
import com.school.system.schoolsystem.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Course createCourse(CourseDto courseDto, Long teacherId) throws CourseException {
        Course course = new Course();
        Teacher teacher = new Teacher();

        boolean teacherExists = teacherRepository.existsById(teacherId);

        if (teacherExists){
            modelMapper.map(courseDto, course);
            teacher.addCourse(course);
            return courseRepository.save(course);
        }else{
            throw new CourseException("Can't create course without a teacher");
        }
    }

    @Override
    public Course updateCourseInfo(CourseDto courseDto, Long courseId) {
        Course courseToUpdate = courseRepository.getById(courseId);
        modelMapper.map(courseDto, courseToUpdate);
        return courseRepository.save(courseToUpdate);
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public Course getACourse(Long courseId) throws CourseException {
        return courseRepository.findById(courseId).orElseThrow(
                () -> new CourseException("Course with " + courseId + " id does not exist"));
    }

    @Override
    public Course getACourseByName(String courseName) throws CourseException {
        return courseRepository.findByName(courseName).orElseThrow(
                () -> new CourseException("Course with " + courseName + " name does not exist"));
    }

    @Override
    public void deleteCourse(Long courseId) throws CourseException {
        Course courseToDelete = courseRepository.findById(courseId).orElseThrow(
                () -> new CourseException("Course with " + courseId + " id does not exist"));
        courseRepository.delete(courseToDelete);
    }
}
