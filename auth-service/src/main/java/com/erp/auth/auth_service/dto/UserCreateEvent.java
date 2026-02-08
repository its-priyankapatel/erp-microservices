package com.erp.auth.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserCreateEvent {
    private UUID userId;
    private String username;
    private String role;
}
