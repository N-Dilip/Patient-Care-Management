package com.example.patientcare.model;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String pass;
    private String pricehomevisit;
    private String pricehospitalvisit;
    private String username;
    private String specialty; 
    private String status = "active"; 
    private String booked = "no"; 
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPricehomevisit() {
        return pricehomevisit;
    }

    public void setPricehomevisit(String pricehomevisit) {
        this.pricehomevisit = pricehomevisit;
    }

    public String getPricehospitalvisit() {
        return pricehospitalvisit;
    }

    public void setPricehospitalvisit(String pricehospitalvisit) {
        this.pricehospitalvisit = pricehospitalvisit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }
}
