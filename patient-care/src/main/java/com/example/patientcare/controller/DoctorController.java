package com.example.patientcare.controller;

import com.example.patientcare.model.Doctor;
import com.example.patientcare.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.findAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Doctor loginRequest) {
        Optional<Doctor> doctor = doctorService.authenticateDoctor(loginRequest.getUsername(), loginRequest.getPass());
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get()); 
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/{doctorId}/status")
    public ResponseEntity<String> updateStatus(@PathVariable String doctorId, @RequestBody Map<String, String> status) {
        String newStatus = status.get("status");

        boolean isUpdated = doctorService.updateDoctorStatus(doctorId, newStatus);

        if (isUpdated) {
            return ResponseEntity.ok("Doctor status updated to: " + newStatus);
        } else {
            return ResponseEntity.status(404).body("Doctor not found with ID: " + doctorId);
        }
    }

    @PostMapping("/{doctorId}/booked")
    public ResponseEntity<String> updateBooked(@PathVariable String doctorId, @RequestBody Map<String, String> booked) {
        String newbooked = booked.get("booked");

        boolean isUpdated = doctorService.updateDoctorBooked(doctorId, newbooked);

        if (isUpdated) {
            return ResponseEntity.ok("Doctor status updated to: " + booked);
        } else {
            return ResponseEntity.status(404).body("Doctor not found with ID: " + doctorId);
        }
    }

}
