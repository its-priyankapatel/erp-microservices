package com.erp.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(
        name = "faculty_profile",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "faculty_profile_employee_id_key",
                        columnNames = "employee_id"
                )
        }
)
public class FacultyProfile {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "employee_id", length = 50, unique = true)
    private String employeeId;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "department_id")
    private UUID departmentId;

    @Column(name = "data_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    // 🔹 Lifecycle hook (preferred over DB triggers)
    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }
}