package com.erp.user_service.controller;

import com.erp.user_service.dto.StudentUpdateRequest;
import com.erp.user_service.dto.UserUpdateResponse;
import com.erp.user_service.service.UserUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/update")
public class UserController {

    private final UserUpdateService userUpdateService;

    public UserController(UserUpdateService userUpdateService)
    {
        this.userUpdateService=userUpdateService;
    }

    @PostMapping("/student")
    public ResponseEntity<UserUpdateResponse>studentUpdate(@RequestBody StudentUpdateRequest studentUpdateRequest)
    {
       UserUpdateResponse response = userUpdateService.userUpdate(studentUpdateRequest);
       return null;
    }

}
