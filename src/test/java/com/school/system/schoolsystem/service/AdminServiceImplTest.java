package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.model.Admin;
import com.school.system.schoolsystem.repository.AdminRepository;
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
class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private AdminServiceImpl adminService = new AdminServiceImpl(modelMapper);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void adminCanBeCreated() throws AdminException {
        AdminDto adminDto = new AdminDto();

        adminDto.setFirstName("Admin name");

        adminService.createAdmin(adminDto);
        ArgumentCaptor<Admin> adminArgumentCaptor = ArgumentCaptor.forClass(Admin.class);

        verify(adminRepository, times(1)).save(adminArgumentCaptor.capture());
        Admin capturedAdmin = adminArgumentCaptor.getValue();

        assertThat(capturedAdmin.getFirstName()).isEqualTo(adminDto.getFirstName());
    }

    @Test
    void testAdminInfoCanBeUpdate() throws AdminException {
        Admin admin = new Admin();
        admin.setFirstName("Jonny");
        admin.setEmail("Jon@mail.com");
        Long adminId = 1L;

        AdminDto adminDto = new AdminDto();
        adminDto.setEmail("John@gmail.com");

        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));
        adminService.updateAdminInfo(adminDto, adminId);

        assertThat(admin.getEmail()).isEqualTo(adminDto.getEmail());
    }

    @Test
    void testAllAdminIsReturned(){
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();

        List<Admin> admins = new ArrayList<>();

        admins.add(admin1);
        admins.add(admin2);

        when(adminRepository.findAll()).thenReturn(admins);

        assertThat(adminService.getAllAdmins()).hasSize(2);
    }

    @Test
    void testAdminCanBeFetchedUsingId() throws AdminException {
        Admin admin = new Admin();
        admin.setFirstName("Jonny");
        admin.setLastName("Doe");
        Long adminId = 1L;


        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));
        adminService.getAdmin(adminId);

        assertThat(admin.getFirstName()).isEqualTo("Jonny");
    }


    @Test
    void adminCanBeDelete() throws AdminException {
        Admin admin = new Admin();
        admin.setFirstName("Jonny");
        admin.setLastName("Doe");
        Long adminId = 1L;
        admin.setAdminId(adminId);


        when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
        adminService.deleteAdmin(admin.getAdminId());

        verify(adminRepository).delete(admin);
    }

}