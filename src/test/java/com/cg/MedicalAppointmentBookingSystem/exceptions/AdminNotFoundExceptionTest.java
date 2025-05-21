package com.cg.MedicalAppointmentBookingSystem.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminNotFoundExceptionTest {

    @Test
    void testAdminNotFoundExceptionMessage() {
        // Define the exception message
        String expectedMessage = "Unauthorized: Not an admin.";

        // Create an instance of the AdminNotFoundException
        AdminNotFoundException exception = new AdminNotFoundException(expectedMessage);

        // Verify that the exception message is correctly passed to the exception
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should match the expected message.");
    }

    @Test
    void testAdminNotFoundExceptionThrown() {
        // Define the exception message
        String expectedMessage = "Unauthorized: Not an admin.";

        // Check if the exception is thrown when trying to simulate the scenario
        Exception exception = assertThrows(AdminNotFoundException.class, () -> {
            // Simulate the code where AdminNotFoundException would be thrown
            throw new AdminNotFoundException(expectedMessage);
        });

        // Verify the exception message
        assertEquals(expectedMessage, exception.getMessage(), "The exception message should be 'Unauthorized: Not an admin.'");
    }
}
