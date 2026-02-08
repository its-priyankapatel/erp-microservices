package com.erp.user_service.repository;

import com.erp.user_service.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyProfile,Long> {
}
