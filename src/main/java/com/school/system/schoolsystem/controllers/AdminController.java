package com.school.system.schoolsystem.controllers;


import com.school.system.schoolsystem.dto.AdminDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/register")
    public ResponseEntity<?> createAdmin(@RequestBody AdminDto adminDto) throws AdminException {
        try {
            return new ResponseEntity<>(adminService.createAdmin(adminDto), HttpStatus.CREATED);
        }catch (AdminException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAdmin(){
        return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.FOUND);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<?> getAdminWithId(@PathVariable Long adminId){
        try {
            return new ResponseEntity<>(adminService.getAdmin(adminId), HttpStatus.FOUND);
        } catch (AdminException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<?> getAdminByName(@PathVariable String firstName) throws AdminException {
        try {
            return new ResponseEntity<>(adminService.getAdminByFirstName(firstName), HttpStatus.FOUND);
        }catch (AdminException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{adminId}")
    public ResponseEntity<?> updateAdminInfo(@RequestBody AdminDto adminDto, @PathVariable Long adminId){
        try {
            return new ResponseEntity<>(adminService.updateAdminInfo(adminDto, adminId), HttpStatus.ACCEPTED);
        } catch (AdminException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long adminId) throws AdminException {
        try {
            adminService.deleteAdmin(adminId);
            return new ResponseEntity<>("Admin deleted successfully", HttpStatus.NO_CONTENT);
        }catch (AdminException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
