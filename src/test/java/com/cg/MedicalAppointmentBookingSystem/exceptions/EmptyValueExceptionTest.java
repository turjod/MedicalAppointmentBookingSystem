package com.cg.MedicalAppointmentBookingSystem.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyValueExceptionTest {

    @Test
    void testEmptyValueExceptionMessage() {
        // Define the exception message
        String expectedMessage = "The value cannot be empty.";

        // Create an instance of the EmptyValueException
        EmptyValueException exception = new EmptyValueException(expectedMessage);

        // Verify that the exception message is correctly passed to the exception
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected message.");
    }

    @Test
    void testEmptyValueExceptionThrown() {
        // Define the exception message
        String expectedMessage = "The value cannot be empty.";

        // Check if the exception is thrown when trying to simulate the scenario
        Exception exception = assertThrows(EmptyValueException.class, () -> {
            // Simulate the code where EmptyValueException would be thrown
            throw new EmptyValueException(expectedMessage);
        });

        // Verify the exception message
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should be 'The value cannot be empty.'");
    }
}
