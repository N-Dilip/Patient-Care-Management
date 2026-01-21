package com.example.patientcare.repository;

import com.example.patientcare.model.Booking;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPatientId(String patientId);
    List<Booking> findByDoctorId(String doctorId);
    @Query("SELECT b FROM Booking b WHERE b.id = :id")
    Optional<Booking> findBookingById(@Param("id") Long id);
}

