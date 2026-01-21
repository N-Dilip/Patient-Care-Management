package com.example.patientcare.controller;

import com.example.patientcare.model.User;
import com.example.patientcare.service.UserServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices UserServices;

    @PostMapping("/signup")
    public void createUser(@RequestBody User user) {
        UserServices.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        User user = UserServices.loginUser(loginUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.ok("invalid");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllPatient() {
        List<User> users = UserServices.findAllPatient();
        return ResponseEntity.ok(users);
    }
}

