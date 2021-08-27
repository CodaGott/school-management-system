package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.repository.StudentRepository;
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
class StudentServiceImplTest {



    @Mock
    private StudentRepository studentRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private StudentServiceImpl studentService = new StudentServiceImpl(modelMapper);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_can_create_student() throws AdminException, StudentException {

        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("Jonny");
        studentDto.setEmail("Jonny@mail.com");

        studentService.createStudent(studentDto);

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository, times(1)).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent.getFirstName()).isEqualTo(studentDto.getFirstName());

    }

    @Test
    void getAStudent() throws StudentException {
        Student student = new Student();
        student.setLastName("lname");
        student.setStudent_id(3L);

        when(studentRepository.findById(student.getStudent_id())).thenReturn(Optional.of(student));

        studentService.getAStudent(student.getStudent_id());

        assertThat(studentService.getAStudent(student.getStudent_id())).isEqualTo(student);

    }

    @Test
    void getAllStudents() {
        Student student = new Student();
        Student student2 = new Student();

        List<Student> students = new ArrayList<>();

        students.add(student);
        students.add(student2);

        when(studentRepository.findAll()).thenReturn(students);

        assertThat(studentService.getAllStudents()).hasSize(2);

    }

    @Test
    void getStudentByName() throws StudentException {
        Student student = new Student();
        student.setFirstName("lname");
        student.setStudent_id(3L);

        when(studentRepository.findByFirstName(student.getFirstName())).thenReturn(Optional.of(student));

        studentService.getStudentByName(student.getFirstName());

        assertThat(student.getFirstName()).isEqualTo("lname");
    }

    @Test
    void updateStudentInfo() throws StudentException {
        Student student = new Student();
        student.setFirstName("lname");
        student.setStudent_id(3L);

        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("John");

        when(studentRepository.findById(student.getStudent_id())).thenReturn(Optional.of(student));
        studentService.updateStudentInfo(studentDto, student.getStudent_id());

        assertThat(student.getFirstName()).isEqualTo(studentDto.getFirstName());
    }

    @Test
    void deleteStudentById() throws StudentException {

        Student student = new Student();
        student.setEmail("email.com");
        student.setStudent_id(9L);

        when(studentRepository.findById(student.getStudent_id())).thenReturn(Optional.of(student));
        studentService.deleteStudentById(student.getStudent_id());

        verify(studentRepository).delete(student);
    }
}