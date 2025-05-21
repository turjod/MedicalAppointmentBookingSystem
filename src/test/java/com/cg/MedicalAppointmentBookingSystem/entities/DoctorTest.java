package com.cg.MedicalAppointmentBookingSystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    void setUp() {
        // Initialize the doctor object with id and name
        doctor = new Doctor("D001", "Dr. John Smith");
    }

    @Test
    void testConstructor() {
        // Verify the doctor's ID and Name
        assertEquals("D001", doctor.getId(), "Doctor ID should be 'D001'.");
        assertEquals("Dr. John Smith", doctor.getName(), "Doctor name should be 'Dr. John Smith'.");
    }

    @Test
    void testAvailability() {
        // Verify that the doctor is available by default
        assertTrue(doctor.isAvailable(), "Doctor should be available by default.");

        // Set doctor as unavailable and verify
        doctor.setAvailable(false);
        assertFalse(doctor.isAvailable(), "Doctor should be unavailable after calling setAvailable(false).");

        // Set doctor back to available and verify
        doctor.setAvailable(true);
        assertTrue(doctor.isAvailable(), "Doctor should be available after calling setAvailable(true).");
    }

    @Test
    void testShowProfile() {
        // Get the doctor profile details
        String profile = doctor.showProfile();

        // Verify the profile details
        assertTrue(profile.contains("Doctor ID: D001"), "Profile should contain Doctor ID.");
        assertTrue(profile.contains("Doctor Name: Dr. John Smith"), "Profile should contain Doctor Name.");
        assertTrue(profile.contains("Available: true"), "Profile should indicate that the doctor is available.");
    }
}
