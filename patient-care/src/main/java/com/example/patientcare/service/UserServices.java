package com.example.patientcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patientcare.model.User;
import com.example.patientcare.repository.UserRepository;


@Service
public class UserServices {

    @Autowired
    private UserRepository UserRepository;

    public void createUser(User user) {
        UserRepository.save(user);
    }

    public User loginUser(User user) {
        User existingUser = UserRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return existingUser;
    }
    
    public List<User> findAllPatient() {
        return UserRepository.findAll();
    }

    
}
