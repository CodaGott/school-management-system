package com.school.system.schoolsystem.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String zip;
}
