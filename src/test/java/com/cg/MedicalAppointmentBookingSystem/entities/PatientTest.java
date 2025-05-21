package com.cg.MedicalAppointmentBookingSystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // Create a new Patient object with ID and Name
        patient = new Patient("P001", "John Doe");
    }

    @Test
    void testConstructor() {
        // Verify the patient's ID and Name
        assertEquals("P001", patient.getId(), "Patient ID should be 'P001'.");
        assertEquals("John Doe", patient.getName(), "Patient name should be 'John Doe'.");
    }

    @Test
    void testShowProfile() {
        // Get the patient profile details
        String profile = patient.showProfile();

        // Verify that the profile contains the correct information
        assertTrue(profile.contains("Patient ID: P001"), "Profile should contain Patient ID.");
        assertTrue(profile.contains("Patient Name: John Doe"), "Profile should contain Patient Name.");
    }
}
