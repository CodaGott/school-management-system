package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String firstName;
//    private String lastName;
//    private Integer age;
    private String email;
//    private String password;
//    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private Address address;
}
