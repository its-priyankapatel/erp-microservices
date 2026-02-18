package com.erp.user_service.repository;

import com.erp.user_service.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile>findByUserId(UUID id);
}
