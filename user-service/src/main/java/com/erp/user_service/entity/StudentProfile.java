package com.erp.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(
        name = "student_profile",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_profile_roll_no_key",
                        columnNames = "roll_no"
                )
        }
)
public class StudentProfile {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "roll_no", length = 50, unique = true)
    private String rollNo;

    @Column(name = "father_name", length = 150)
    private String fatherName;

    @Column(name = "mother_name", length = 150)
    private String motherName;

    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "branch_id")
    private UUID branchId;

    @Column(name = "section", length = 10)
    private String section;

    @Column(name = "department_id")
    private UUID departmentId;

    @Column(name = "course_semester")
    private Integer courseSemester;

    @Column(name = "course_year")
    private Integer courseYear;

    @Column(name = "admission_year")
    private Integer admissionYear;

    @Column(name = "guardian_number", length = 20)
    private String guardianNumber;

    @Column(name = "emergency_number", length = 20)
    private String emergencyNumber;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    // 🔹 Lifecycle hook (preferred in services)
    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }
}