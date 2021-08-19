package com.school.system.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String zip;
}
