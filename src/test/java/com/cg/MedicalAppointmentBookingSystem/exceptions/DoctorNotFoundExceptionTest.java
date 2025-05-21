package com.cg.MedicalAppointmentBookingSystem.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorNotFoundExceptionTest {

    @Test
    void testDoctorNotFoundExceptionMessage() {
        // Define the exception message
        String expectedMessage = "Doctor not found in the system.";

        // Create an instance of the DoctorNotFoundException
        DoctorNotFoundException exception = new DoctorNotFoundException(expectedMessage);

        // Verify that the exception message is correctly passed to the exception
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected message.");
    }

    @Test
    void testDoctorNotFoundExceptionThrown() {
        // Define the exception message
        String expectedMessage = "Doctor not found in the system.";

        // Check if the exception is thrown when trying to simulate the scenario
        Exception exception = assertThrows(DoctorNotFoundException.class, () -> {
            // Simulate the code where DoctorNotFoundException would be thrown
            throw new DoctorNotFoundException(expectedMessage);
        });

        // Verify the exception message
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should be 'Doctor not found in the system.'");
    }
}
