package com.erp.auth.auth_service.event;

import com.erp.auth.auth_service.dto.UserCreateEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserEventPublisher {

    private RestTemplate restTemplate;
    public UserEventPublisher(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    private final String baseUrl = "http://localhost:8080/user/internal/";

    public void publishUserCreated(UserCreateEvent userCreateEvent)
    {
        try
        {
         ResponseEntity<String> result= restTemplate.postForEntity(baseUrl,userCreateEvent,String.class);
            System.out.println(result.getBody());
        }catch(Exception e)
        {
            System.out.println("Unable to send Event"+e);
         e.printStackTrace();
        }
    }
}
