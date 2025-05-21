package com.cg.MedicalAppointmentBookingSystem.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidAppointmentExceptionTest {

    @Test
    void testInvalidAppointmentExceptionMessage() {
        // Define the exception message
        String expectedMessage = "The appointment is invalid due to incorrect data.";

        // Create an instance of the InvalidAppointmentException
        InvalidAppointmentException exception = new InvalidAppointmentException(expectedMessage);

        // Verify that the exception message is correctly passed to the exception
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected message.");
    }

    @Test
    void testInvalidAppointmentExceptionThrown() {
        // Define the exception message
        String expectedMessage = "The appointment is invalid due to incorrect data.";

        // Check if the exception is thrown when trying to simulate the scenario
        Exception exception = assertThrows(InvalidAppointmentException.class, () -> {
            // Simulate the code where InvalidAppointmentException would be thrown
            throw new InvalidAppointmentException(expectedMessage);
        });

        // Verify the exception message
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should be 'The appointment is invalid due to incorrect data.'");
    }
}
