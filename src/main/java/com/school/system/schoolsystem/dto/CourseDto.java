package com.school.system.schoolsystem.dto;

import com.school.system.schoolsystem.model.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseDto {
    private String name;
    private LocalDateTime time;
    private List<Student> students;
    private Integer scores;
    private String remark;
}
