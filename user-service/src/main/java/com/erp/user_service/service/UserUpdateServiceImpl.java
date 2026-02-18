package com.erp.user_service.service;

import com.erp.user_service.dto.StudentUpdateRequest;
import com.erp.user_service.dto.UserUpdateResponse;
import com.erp.user_service.entity.UserProfile;
import com.erp.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserUpdateServiceImpl implements UserUpdateService{

    private final UserRepository userRepository;

    public UserUpdateServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public UserUpdateResponse userUpdate(StudentUpdateRequest studentUpdateRequest) {
     Optional <UserProfile> user = userRepository.findByUserId(studentUpdateRequest.getId());
     if(!user.isPresent())
     {
        return new UserUpdateResponse(false,"User not exist",null);
     }
     return null;
    }

}
