package com.erp.user_service.service;

import com.erp.user_service.dto.StudentUpdateRequest;
import com.erp.user_service.dto.UserUpdateResponse;

public interface UserUpdateService {
    UserUpdateResponse userUpdate(StudentUpdateRequest studentUpdateRequest);
}
