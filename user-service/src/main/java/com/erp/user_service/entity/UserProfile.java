package com.erp.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_profile", schema = "public")
public class UserProfile {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "first_name", length = 26)
    private String firstName;

    @Column(name = "last_name", length = 26)
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "status", length = 20)
    private String status = "ACTIVE";

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    // 🔹 Lifecycle hooks (industry standard)
    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }

}
