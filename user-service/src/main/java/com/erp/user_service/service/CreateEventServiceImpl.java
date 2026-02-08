package com.erp.user_service.service;

import com.erp.user_service.dto.UserCreateEvent;
import com.erp.user_service.entity.FacultyProfile;
import com.erp.user_service.entity.StudentProfile;
import com.erp.user_service.entity.UserProfile;
import com.erp.user_service.repository.FacultyRepository;
import com.erp.user_service.repository.StudentRepository;
import com.erp.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateEventServiceImpl implements CreateEventService{

    private  UserRepository userRepository;
    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;
    public CreateEventServiceImpl(UserRepository userRepository,StudentRepository studentRepository, FacultyRepository facultyRepository)
    {
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
        this.facultyRepository=facultyRepository;
    }
    public void createUser(UserCreateEvent userCreateEvent)
    {
        UserProfile user=new UserProfile();
        user.setUserId(userCreateEvent.getUserId());
        user.setUsername(userCreateEvent.getUsername());
        user.setRole(userCreateEvent.getRole());

        userRepository.save(user);

        if(userCreateEvent.getRole().equals("STUDENT")){
            StudentProfile student=new StudentProfile();
            student.setUserId(userCreateEvent.getUserId());
             studentRepository.save(student);
        }else if(userCreateEvent.getRole().equals("FACULTY")){
            FacultyProfile faculty=new FacultyProfile();
            faculty.setUserId(userCreateEvent.getUserId());
            facultyRepository.save(faculty);
        }else {

        }

    }
}
