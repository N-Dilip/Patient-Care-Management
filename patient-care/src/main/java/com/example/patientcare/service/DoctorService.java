package com.example.patientcare.service;

import com.example.patientcare.model.Doctor;
import com.example.patientcare.repository.DoctorRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> authenticateDoctor(String username, String pass) {
        return doctorRepository.findByUsernameAndPass(username, pass);
    }

  
    @Transactional
    public boolean updateDoctorStatus(String doctorId, String status) {
        int rowsUpdated = doctorRepository.updateDoctorStatus(doctorId, status);
        return rowsUpdated > 0;
    }

    @Transactional
    public boolean updateDoctorBooked(String doctorId, String booked) {
        int rowsUpdated = doctorRepository.updateDoctorBooked(doctorId, booked);
        return rowsUpdated > 0;
    }

    
}
