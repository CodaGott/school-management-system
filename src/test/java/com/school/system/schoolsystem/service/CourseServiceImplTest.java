package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.CourseDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Teacher;
import com.school.system.schoolsystem.repository.CourseRepository;
import com.school.system.schoolsystem.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {


    @Mock
    private CourseRepository courseRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private CourseServiceImpl courseService = new CourseServiceImpl(modelMapper);


    @Test
    void testCourseCanBeCreated() throws CourseException {
        CourseDto courseDto = new CourseDto();

        Teacher teacher = new Teacher();

        courseDto.setName("name");
        courseDto.setRemark("cool");
        courseDto.setScores(78);
        Long teacherId = 1L;



        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(teacher));

        courseService.createCourse(courseDto, teacherId);


        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);
        ArgumentCaptor<Teacher> teacherArgumentCaptor = ArgumentCaptor.forClass(Teacher.class);

        verify(courseRepository, times(1)).save(courseArgumentCaptor.capture());
        verify(teacherRepository, times(1)).save(teacherArgumentCaptor.capture());

        Course capturedCourse = courseArgumentCaptor.getValue();
        Teacher capturedTeacher = teacherArgumentCaptor.getValue();

        assertThat(capturedCourse.getName()).isEqualTo(courseDto.getName());
        assertThat(capturedCourse.getRemark()).isEqualTo(courseDto.getRemark());
        assertThat(capturedTeacher.getCourses()).isNotEmpty();

    }


    @Test
    void testCourseInfoCanBeUpdated() throws CourseException {
        Course course = new Course();
        course.setRemark("Good");
        course.setScore(67);
        course.setName("Java");
        course.setCourseId(1L);

        CourseDto courseToUpdate = new CourseDto();
        courseToUpdate.setRemark("Best");

        when(courseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
        courseService.updateCourseInfo(courseToUpdate, course.getCourseId());

        assertThat(course.getRemark()).isEqualTo(courseToUpdate.getRemark());
    }



    @Test
    void testCourseCanBeFetchedById() throws CourseException {
        Course course = new Course();
        Long courseId = 1L;

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        courseService.getACourse(courseId);

        assertThat(courseService.getACourse(courseId)).isEqualTo(course);
    }


    @Test
    void testCourseCanBeFetchedByName() throws CourseException {
        Course course = new Course();
        course.setName("Java");

        when(courseRepository.findByName(course.getName())).thenReturn(Optional.of(course));
        courseService.getACourseByName(course.getName());

        assertThat(courseService.getACourseByName(course.getName())).isEqualTo(course);
    }


    @Test
    void testCourseCanBeDeleted() throws CourseException {

        Course course = new Course();
        course.setRemark("Good");
        course.setScore(67);
        course.setName("Java");
        course.setCourseId(1L);

       when(courseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
       courseService.deleteCourse(course.getCourseId());

       verify(courseRepository, times(1)).delete(course);
    }


}