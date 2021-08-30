package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.TeacherDto;
import com.school.system.schoolsystem.exception.CourseException;
import com.school.system.schoolsystem.exception.TeacherException;
import com.school.system.schoolsystem.model.Course;
import com.school.system.schoolsystem.model.Teacher;
import com.school.system.schoolsystem.repository.CourseRepository;
import com.school.system.schoolsystem.repository.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private CourseRepository courseRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @InjectMocks
    private TeacherServiceImpl teacherService = new TeacherServiceImpl(modelMapper);

    Course testCourse;


    @BeforeEach
    void setUp() {
        testCourse = new Course();
        testCourse.setName("Java");
        testCourse.setScore(70);
        testCourse.setRemark("Good but can be better");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testThatTeacherCanBeCreated() throws CourseException, TeacherException {
        //Given
        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setFirstName("John");
        teacherDto.setLastName("Doe");
        teacherDto.setAge(20);
        Long courseId = 1L;


        //When
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(testCourse));
        teacherService.createTeacher(teacherDto, courseId);
        ArgumentCaptor<Teacher> teacherArgumentCaptor = ArgumentCaptor.forClass(Teacher.class);

        //then
        verify(teacherRepository, times(1)).save(teacherArgumentCaptor.capture());

        Teacher capturedTeacher = teacherArgumentCaptor.getValue();

        assertThat(capturedTeacher.getFirstName()).isEqualTo(teacherDto.getFirstName());
        assertThat(capturedTeacher.getCourses()).isNotNull();
    }


    @Test
    void testThatTeacherInfoCanBeUpdated() throws TeacherException {
        Teacher teacher = new Teacher();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setEmail("john@gmail.com");
        Long id = 1L;

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setEmail("John2@gmailcom");

        when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));

        teacherService.updateTeacherInfo(teacherDto, id);
        ArgumentCaptor<Teacher> teacherArgumentCaptor = ArgumentCaptor.forClass(Teacher.class);

        verify(teacherRepository, times(1)).save(teacherArgumentCaptor.capture());

        Teacher capturedTeacher = teacherArgumentCaptor.getValue();
        assertThat(capturedTeacher.getFirstName()).isEqualTo(teacherDto.getFirstName());
        // explicitly stating the value of firstName in the line above will return a null value because we are
        // injecting the modelMapper her and when injected the setSkipNullEnabled(true) method can't be access.
        assertThat(capturedTeacher.getEmail()).isEqualTo("John2@gmailcom");

    }

    @Test
    void testThatAllTeachersCanBeFound(){
        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();


        List<Teacher> teachers = new ArrayList<>();
        teacher.setFirstName("Emeka");
        teacher1.setFirstName("Jonny");
        teacher2.setFirstName("Janny");
        teacher3.setFirstName("Joe");
        teachers.add(teacher3);
        teachers.add(teacher2);
        teachers.add(teacher);
        teachers.add(teacher1);

        when(teacherRepository.findAll()).thenReturn(teachers);

        assertThat(teacherService.getTeachers()).hasSize(4);
    }

    @Test
    void testThatATeacherCanBeFoundUsingId() throws TeacherException {

        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();

        teacher.setFirstName("Emeka");
        teacher1.setFirstName("Jonny");
        teacher2.setFirstName("Janny");
        teacher3.setFirstName("Joe");
        teacher.setId(1L);

        when(teacherRepository.findById(teacher.getId())).thenReturn(Optional.of(teacher));

        assertThat(teacherService.getATeacher(teacher.getId())).isEqualTo(teacher);
    }


    @Test
    void testThatATeacherCanBeFoundUsingName() throws TeacherException {
        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();

        teacher.setFirstName("Emeka");
        teacher1.setFirstName("Jonny");
        teacher2.setFirstName("Janny");
        teacher3.setFirstName("Joe");
        teacher.setId(1L);

        when(teacherRepository.findByFirstName(teacher1.getFirstName())).thenReturn(Optional.of(teacher1));
        assertThat(teacherService.findATeacherByName(teacher1.getFirstName())).isEqualTo(teacher1);
    }

    @Test
    void testThatATeacherCanBeDeleted() throws TeacherException {

        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();

        teacher.setFirstName("Emeka");
        teacher1.setFirstName("Jonny");
        teacher2.setFirstName("Janny");
        teacher3.setFirstName("Joe");
        teacher.setId(1L);

        when(teacherRepository.findById(teacher.getId())).thenReturn(Optional.of(teacher));

        teacherService.deleteATeacher(teacher.getId());
        verify(teacherRepository).delete(teacher);
    }
}