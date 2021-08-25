package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.ClassDto;
import com.school.system.schoolsystem.exception.ClassException;
import com.school.system.schoolsystem.model.ClassRoom;
import com.school.system.schoolsystem.repository.ClassRepository;
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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClassServiceImplTest {

    @Mock
    private ClassRepository classRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private ClassServiceImpl classService = new ClassServiceImpl(modelMapper);



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testYouCanCreateClass() throws ClassException {
        ClassDto classDto = new ClassDto();

        classDto.setName("Village");

        classService.createClass(classDto);

        ArgumentCaptor<ClassRoom> classArgumentCaptor = ArgumentCaptor.forClass(ClassRoom.class);

        verify(classRepository, times(1)).save(classArgumentCaptor.capture());

        ClassRoom capturedClass = classArgumentCaptor.getValue();

        assertThat(capturedClass.getName()).isEqualTo(classDto.getName());
    }

    @Test
    void getAClassById() throws ClassException {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("class");
        classRoom.setId(1L);

        when(classRepository.findById(classRoom.getId())).thenReturn(Optional.of(classRoom));
        classService.getAClass(classRoom.getId());

        assertThat(classService.getAClass(classRoom.getId())).isEqualTo(classRoom);
    }

    @Test
    void testYouCanUpdateClassInfo() throws ClassException {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("Goal class");
        classRoom.setId(1L);

        ClassDto classToUpdate = new ClassDto();
        classToUpdate.setName("Java Class");

        when(classRepository.findById(classRoom.getId())).thenReturn(Optional.of(classRoom));
        classService.updateClassInfo(classToUpdate, classRoom.getId());

        assertThat(classRoom.getName()).isEqualTo(classToUpdate.getName());
    }

    @Test
    void testYouGetAllClasses() {
        ClassRoom classRoom = new ClassRoom();
        ClassRoom classRoom1 = new ClassRoom();
        ClassRoom classRoom2 = new ClassRoom();

        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms.add(classRoom);
        classRooms.add(classRoom2);
        classRooms.add(classRoom1);

        when(classRepository.findAll()).thenReturn(classRooms);

        assertThat(classService.getAllClasses()).hasSize(3);

    }

    @Test
    void testYouCanDeleteClass() throws ClassException {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("Goal class");
        classRoom.setId(1L);

        when(classRepository.findById(classRoom.getId())).thenReturn(Optional.of(classRoom));
        classService.deleteClass(classRoom.getId());

        verify(classRepository).delete(classRoom);
    }

    @Test
    void testYouCanGetAClassByName() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("Goal class");
        classRoom.setId(1L);

        when(classRepository.findByName(classRoom.getName())).thenReturn(Optional.of(classRoom));
        classService.getAClassByName(classRoom.getName());

        assertThat(classRoom.getName()).isEqualTo("Goal class");
    }
}