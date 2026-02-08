package com.erp.auth.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(
        name = "auth_user",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "auth_user_username_key", columnNames = "username")
        }
)
public class AuthUser {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password_hash", nullable = false, columnDefinition = "text")
    private String passwordHash;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "last_login_at")
    private OffsetDateTime lastLoginAt;

    // 🔹 Lifecycle hooks (recommended over DB-only defaults)
    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }
}