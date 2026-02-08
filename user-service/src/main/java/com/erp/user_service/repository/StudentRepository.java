package com.erp.user_service.repository;

import com.erp.user_service.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentProfile,Long> {
}
