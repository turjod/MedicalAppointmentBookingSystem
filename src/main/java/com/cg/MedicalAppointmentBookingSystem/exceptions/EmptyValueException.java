package com.cg.MedicalAppointmentBookingSystem.exceptions;
/**
 * This class represents a custom exception that is thrown when a value is empty.
 *
 * @author Suchismita
 */
public class EmptyValueException extends RuntimeException {
    public EmptyValueException(String message) {
        super(message); // Call the constructor of the parent class (RuntimeException)
    }
}
