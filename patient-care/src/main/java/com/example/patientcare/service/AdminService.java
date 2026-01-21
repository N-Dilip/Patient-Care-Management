package com.example.patientcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patientcare.model.Doctor;
import com.example.patientcare.model.User;
import com.example.patientcare.repository.DoctorRepository;
import com.example.patientcare.repository.UserRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;


    public void createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<User> getAllPatient() {
        return userRepository.findAll();
    }
}
