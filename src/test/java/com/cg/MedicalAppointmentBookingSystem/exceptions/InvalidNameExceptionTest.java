package com.cg.MedicalAppointmentBookingSystem.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidNameExceptionTest {

    @Test
    void testInvalidNameExceptionMessage() {
        // Define the exception message
        String expectedMessage = "The name provided is invalid.";

        // Create an instance of the InvalidNameException
        InvalidNameException exception = new InvalidNameException(expectedMessage);

        // Verify that the exception message is correctly passed to the exception
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected message.");
    }

    @Test
    void testInvalidNameExceptionThrown() {
        // Define the exception message
        String expectedMessage = "The name provided is invalid.";

        // Check if the exception is thrown when trying to simulate the scenario
        Exception exception = assertThrows(InvalidNameException.class, () -> {
            // Simulate the code where InvalidNameException would be thrown
            throw new InvalidNameException(expectedMessage);
        });

        // Verify the exception message
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should be 'The name provided is invalid.'");
    }
}
