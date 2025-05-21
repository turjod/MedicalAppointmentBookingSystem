package com.cg.MedicalAppointmentBookingSystem.exceptions;

public class DuplicateIdException extends RuntimeException {
    public DuplicateIdException(String message) {
        super(message);
    }
}
