package com.erp.user_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class StudentUpdateRequest {
    private String username;
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String branch;
    private String department;
    private String email;
    private String phone;
    private String fatherName;
    private String motherName;
    private String course;
    private String courseYear;
    private String semester;
    private String section;
    private String admissionYear;
    private String guardianNumber;
    private String emergencyNumber;
    private String bloodGroup;
    private String status;
}
