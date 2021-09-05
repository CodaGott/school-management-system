package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String name;
    private LocalDateTime time;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "student_id"
            )
    )
    private List<Student> students;
    private Integer score;
    private String remark;

    public void addStudent(Student student){
        if (students == null){
            this.students = new ArrayList<>();
        }
        this.students.addAll(Collections.singletonList(student));
    }

    public void removeStudentFromCourse(Student student){
        if (students == null){
            this.students = new ArrayList<>();
        }else {
            this.students.remove(student);
        }
    }
}
