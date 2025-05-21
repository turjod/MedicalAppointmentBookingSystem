package com.cg.MedicalAppointmentBookingSystem.exceptions;
/**
 * AdminNotFoundException is a custom exception class that extends RuntimeException.
 * it is thrown when an admin is not found in the system.
 *
 * @author Dipanjan
 */
public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException(String message) {
		super(message);
	}
}
