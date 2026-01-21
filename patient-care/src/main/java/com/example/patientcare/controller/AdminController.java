package com.example.patientcare.controller;

import com.example.patientcare.model.Doctor;
import com.example.patientcare.model.User;
import com.example.patientcare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createDoctor")
    public void createDoctor(@RequestBody Doctor doctor) {
        adminService.createDoctor(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return adminService.getAllDoctors();
    }

    @GetMapping("/patient")
    public List<User> getAllPatient() {
        return adminService.getAllPatient();
    }
}

