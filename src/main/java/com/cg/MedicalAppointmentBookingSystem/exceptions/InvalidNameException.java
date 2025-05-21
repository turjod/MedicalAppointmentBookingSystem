package com.cg.MedicalAppointmentBookingSystem.exceptions;
/**
 * This class represents a custom exception that is thrown when a value is empty.
 *
 * @author Dipanjan
 */
public class InvalidNameException extends RuntimeException {
	public InvalidNameException(String message) {
		super(message);
	}
}
