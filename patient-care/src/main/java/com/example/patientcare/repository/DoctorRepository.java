package com.example.patientcare.repository;

import com.example.patientcare.model.Doctor;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.booked = :status WHERE d.id = :doctorId")
    void updateDoctorBookingStatus(String doctorId, String status);
    Optional<Doctor> findByUsernameAndPass(String username, String pass);

    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.status = :status WHERE d.id = :doctorId")
    int updateDoctorStatus(String doctorId, String status);

    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.booked = :booked WHERE d.id = :doctorId")
    int updateDoctorBooked(String doctorId, String booked);
    
    
}
