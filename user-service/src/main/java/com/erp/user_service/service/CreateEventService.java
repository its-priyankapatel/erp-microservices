package com.erp.user_service.service;

import com.erp.user_service.dto.UserCreateEvent;

public interface CreateEventService {
     void createUser(UserCreateEvent userCreateEvent);
}
