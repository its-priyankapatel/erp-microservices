package com.erp.user_service.controller;

import com.erp.user_service.dto.UserCreateEvent;
import com.erp.user_service.service.CreateEventService;
import com.erp.user_service.service.CreateEventServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/internal")
public class EventReceiver {
    private CreateEventService createEventService;
    public EventReceiver(CreateEventService createEventService)
    {
        this.createEventService = createEventService;
    }
    @PostMapping("/")
    public ResponseEntity<String> onUserCreate(@RequestBody UserCreateEvent userCreateEvent){
         createEventService.createUser(userCreateEvent);
         return ResponseEntity.status(HttpStatus.OK).body("User Created successfully");
    }
}
