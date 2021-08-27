package com.school.system.schoolsystem.service;

import com.school.system.schoolsystem.dto.StudentDto;
import com.school.system.schoolsystem.exception.AdminException;
import com.school.system.schoolsystem.exception.StudentException;
import com.school.system.schoolsystem.model.Student;
import com.school.system.schoolsystem.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private ModelMapper modelMapper;

    public StudentServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public Student createStudent(StudentDto studentDto) throws StudentException, AdminException {
        Student student = new Student();

        boolean studentExists = studentRepository.findByEmail(student.getEmail()).isPresent();

        if (studentExists){
            throw new StudentException("Student with email already exists");
        }
        modelMapper.map(studentDto, student);
//        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    @Override
    public Student getAStudent(Long studentId) throws StudentException {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new StudentException("Student with " + studentId + " not present"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByName(String studentFirstName) throws StudentException {

        return studentRepository.findByFirstName(studentFirstName).orElseThrow(
                () -> new StudentException("Student with " + studentFirstName + " not present"));
    }

    @Override
    public Student updateStudentInfo(StudentDto studentDto, Long studentId) throws StudentException {

        Student studentToUpdate = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentException("Student with " + studentId + " not present"));
        modelMapper.map(studentDto, studentToUpdate);
        return studentRepository.save(studentToUpdate);
    }

    @Override
    public void deleteStudentById(Long studentId) throws StudentException {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentException("Student with " + studentId + " not present"));
        studentRepository.delete(student);
    }
}
