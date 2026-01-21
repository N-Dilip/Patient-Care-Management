package com.example.patientcare.controller;

import com.example.patientcare.model.Booking;
import com.example.patientcare.service.BookingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createBooking(@RequestBody Booking booking) {
       
        Booking savedBooking = bookingService.createBooking(booking);

        Map<String, Object> response = new HashMap<>();
        response.put("id", savedBooking.getId()); 

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Booking>> getBookings(@PathVariable String doctorId) {
        List<Booking> bookings = bookingService.getBookingsForDoctor(doctorId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/user/{patientId}")
    public List<Booking> getBookingsByPatientId(@PathVariable String patientId) {
        return bookingService.findBookingsByPatientId(patientId);
    }

    @PostMapping("/{bookingId}/complete")
    public ResponseEntity<String> markBookingAsComplete(@PathVariable Long bookingId) {
        boolean isUpdated = bookingService.markBookingAsComplete(bookingId);
        if (isUpdated) {
            return ResponseEntity.ok("Booking marked as completed.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found.");
        }
    }
}
