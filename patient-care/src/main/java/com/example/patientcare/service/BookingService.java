package com.example.patientcare.service;

import com.example.patientcare.model.Booking;
import com.example.patientcare.repository.BookingRepository;
import com.example.patientcare.repository.DoctorRepository;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
     @Autowired
    private DoctorRepository doctorRepository;

    public Booking createBooking(Booking booking) {
        
        Booking savedBooking = bookingRepository.save(booking);
        String doctorId = booking.getDoctorId();
        doctorRepository.updateDoctorBookingStatus(doctorId, "yes");
        return savedBooking;
    }

    public List<Booking> findBookingsByPatientId(String patientId) {
        return bookingRepository.findByPatientId(patientId);
    }

    public List<Booking> getBookingsForDoctor(String doctorId) {
        return bookingRepository.findByDoctorId(doctorId);
    }

    public boolean markBookingAsComplete(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus("completed");
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

}
