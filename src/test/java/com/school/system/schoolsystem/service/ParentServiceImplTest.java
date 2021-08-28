package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ParentDto;
import com.school.system.schoolsystem.exception.ParentException;
import com.school.system.schoolsystem.model.Parent;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.repository.ParentRepository;
import com.school.system.schoolsystem.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParentServiceImplTest {

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Mock
    private ParentRepository parentRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ParentServiceImpl parentService = new ParentServiceImpl(modelMapper);



    @Test
    void testParentCanBeCreated() throws ParentException {
        ParentDto parentDto = new ParentDto();
        Student student = new Student();


        Long studentId = 4L;

        parentDto.setFirstName("Jonny");
        parentDto.setEmail("Jonny@email.com");
        parentDto.setLastName("Doe");

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        parentService.createParent(parentDto, studentId);

        ArgumentCaptor<Parent> parentArgumentCaptor = ArgumentCaptor.forClass(Parent.class);

        verify(parentRepository, times(1)).save(parentArgumentCaptor.capture());

        Parent capturedParent = parentArgumentCaptor.getValue();

        assertThat(capturedParent.getEmail()).isEqualTo(parentDto.getEmail());

    }

    @Test
    void testParentInfoCanBeUpdated() throws ParentException {
        Parent parent = new Parent();
        parent.setEmail("Jonh@email.com");
        Long parentId = 9L;

        ParentDto parentToUpdate = new ParentDto();
        parentToUpdate.setEmail("Jonny@email.com");

        when(parentRepository.findById(parentId)).thenReturn(Optional.of(parent));

        parentService.updateParentInfo(parentToUpdate, parentId);

        ArgumentCaptor<Parent> parentArgumentCaptor = ArgumentCaptor.forClass(Parent.class);

        verify(parentRepository, times(1)).save(parentArgumentCaptor.capture());

        Parent capturedParent = parentArgumentCaptor.getValue();

        assertThat(capturedParent.getEmail()).isEqualTo(parentToUpdate.getEmail());

        assertThat(capturedParent.getEmail()).isEqualTo("Jonny@email.com");
    }

}