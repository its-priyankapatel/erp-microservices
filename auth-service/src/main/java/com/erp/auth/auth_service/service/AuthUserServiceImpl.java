package com.erp.auth.auth_service.service;

import com.erp.auth.auth_service.dto.LoginRequest;
import com.erp.auth.auth_service.dto.ProvisionUserRequest;
import com.erp.auth.auth_service.dto.UserCreateEvent;
import com.erp.auth.auth_service.entity.*;
import com.erp.auth.auth_service.event.UserEventPublisher;
import com.erp.auth.auth_service.exception.IncompleteData;
import com.erp.auth.auth_service.exception.InvalidCredentialsException;
import com.erp.auth.auth_service.exception.UserAlreadyExist;
import com.erp.auth.auth_service.exception.UserNotActiveException;
import com.erp.auth.auth_service.repository.AuthUserRepository;
import com.erp.auth.auth_service.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class AuthUserServiceImpl implements AuthUserService {

    private final  JwtUtil jwtUtil;
    private final AuthUserRepository authUserRepository;
    private final  BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserEventPublisher userEventPublisher;

    public AuthUserServiceImpl(AuthUserRepository authUserRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder,JwtUtil jwtUtil,UserEventPublisher userEventPublisher) {
        this.authUserRepository = authUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtUtil=jwtUtil;
        this.userEventPublisher=userEventPublisher;
    }

    @Override
    public String provisionUser(ProvisionUserRequest request) {

        if (request.getUsername() == null ||
                request.getRole() == null ||
                request.getTempPassword() == null) {
            throw new IncompleteData("Username, role and temporary password are required");
        }
        if(!List.of("STUDENT","FACULTY","ADMIN").contains(request.getRole()))
        {
            throw new IllegalStateException("User Role is not Valid");
        }

        if (authUserRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExist("User already provisioned");
        }

        try{
            String hashedPassword = bCryptPasswordEncoder.encode(request.getTempPassword());

            AuthUser user = new AuthUser();
            user.setId(UUID.randomUUID());
            user.setUsername(request.getUsername());
            user.setPasswordHash(hashedPassword);
            user.setRole(request.getRole().toUpperCase());
            user.setStatus("ACTIVE");

            AuthUser result= authUserRepository.save(user);

            userEventPublisher.publishUserCreated(new UserCreateEvent(result.getId(),result.getUsername(),result.getRole()));
        } catch (Exception e) {
            log.error("INTERNAL SERVER ERROR:",e);
            throw new RuntimeException(e);
        }
        return "User provisioned successfully";
    }


    @Override
    public Optional<AuthUser> findByUsername(String username) {
        return authUserRepository.findByUsername(username);
    }

    @Override
    public String login(LoginRequest request) {


        AuthUser user = authUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        if (!user.getStatus().equals("ACTIVE")) {
            throw new UserNotActiveException("User is not active");
        }

        return jwtUtil.generateToken(
                user.getUsername(),
                user.getRole()
        );
    }

}

