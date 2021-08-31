package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Teacher;
import com.school.system.schoolsystem.repository.CourseRepository;
import com.school.system.schoolsystem.repository.TeacherRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CourseServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public Course createCourse(CourseDto courseDto, Long teacherId) throws CourseException {
        Course course = new Course();
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if (optionalTeacher.isPresent()){
            modelMapper.map(courseDto, course);
            Teacher teacher = optionalTeacher.get();
            Course savedCourse = courseRepository.save(course);
            teacher.addCourse(savedCourse);
            teacherRepository.save(teacher);
            return savedCourse;
        }else{
            throw new CourseException("Can't create course without a teacher");
        }
    }

    @Override
    public Course updateCourseInfo(CourseDto courseDto, Long courseId) throws CourseException {
        Course courseToUpdate = courseRepository.findById(courseId).orElseThrow(
                () -> new CourseException("Teacher with " + courseId + " does not exist")
        );

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

    @Override
    public void addStudentToCourse(Long studentId, Long courseId) {

    }
}
