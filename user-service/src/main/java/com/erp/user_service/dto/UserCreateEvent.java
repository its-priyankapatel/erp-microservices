package com.erp.user_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserCreateEvent {
    private UUID userId;
    private String username;
    private String role;
}
