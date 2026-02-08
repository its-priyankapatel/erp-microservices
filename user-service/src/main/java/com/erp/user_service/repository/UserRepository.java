package com.erp.user_service.repository;

import com.erp.user_service.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserProfile,Long> {

}
