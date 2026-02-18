package com.erp.user_service.repository;

import com.erp.user_service.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentProfile,UUID> {
    Optional<StudentProfile> findById(UUID id);
}
