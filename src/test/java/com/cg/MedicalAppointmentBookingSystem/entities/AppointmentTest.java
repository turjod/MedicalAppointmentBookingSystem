package com.cg.MedicalAppointmentBookingSystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        // Create real instances of Patient and Doctor
        patient = new Patient("P001", "John Doe");
        doctor = new Doctor("D001", "Dr. Smith");

        // Create the Appointment using the Patient and Doctor
        appointment = new Appointment(patient, doctor);
    }

    @Test
    void testAppointmentConstructor() {
        // Verify that the appointment is correctly initialized
        assertNotNull(appointment.getPatient(), "The patient should not be null.");
        assertNotNull(appointment.getDoctor(), "The doctor should not be null.");
        assertEquals("John Doe", appointment.getPatient().getName(), "The patient's name should be 'John Doe'.");
        assertEquals("Dr. Smith", appointment.getDoctor().getName(), "The doctor's name should be 'Dr. Smith'.");
        
        // Verify that the appointment status is "Scheduled"
        assertEquals("Scheduled", appointment.getStatus(), "The status should be 'Scheduled' initially.");
        
        // Verify that the doctor's availability is set to false
        assertFalse(doctor.isAvailable(), "The doctor's availability should be 'false' after the appointment is created.");
    }

    @Test
    void testCompletedAppointment() {
        // Verify the status before completing the appointment
        assertEquals("Scheduled", appointment.getStatus(), "The status should be 'Scheduled' before completing the appointment.");
        
        // Call completedAppointment() to mark the appointment as completed
        appointment.completedAppointment();
        
        // Verify the status is now "Completed"
        assertEquals("Completed", appointment.getStatus(), "The status should be 'Completed' after the appointment is marked as completed.");
        
        // Verify that the doctor's availability is set back to true
        assertTrue(doctor.isAvailable(), "The doctor's availability should be 'true' after the appointment is completed.");
    }

    @Test
    void testAppointmentDetails() {
        // Call the appointmentDetails() method and get the result
        String details = appointment.appointmentDetails();
        
        // Verify the content of the returned appointment details
        assertTrue(details.contains("Patient: John Doe"), "The appointment details should contain the patient's name.");
        assertTrue(details.contains("Doctor: Dr. Smith"), "The appointment details should contain the doctor's name.");
        assertTrue(details.contains("Status: Scheduled"), "The appointment details should contain the status 'Scheduled'.");
    }
}