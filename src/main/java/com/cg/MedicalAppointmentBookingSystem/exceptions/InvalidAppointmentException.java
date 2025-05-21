package com.cg.MedicalAppointmentBookingSystem.exceptions;
/**
 * InvalidAppointmentException is a custom exception class that extends the Exception class.
 * It is used to indicate that an appointment is invalid.
 * This exception can be thrown when an appointment cannot be created due to various reasons.
 *
 * @author Subhranil
 */
public class InvalidAppointmentException extends RuntimeException {
    public InvalidAppointmentException(String message) {
        super(message);
    }
}