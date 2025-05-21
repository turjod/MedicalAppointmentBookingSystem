package com.cg.MedicalAppointmentBookingSystem.exceptions;
/**
 * AdminNotFoundException is a custom exception class that extends RuntimeException.
 * It is thrown when an admin is not found in the system.
 *
 * @author Dipanjan
 */
public class IdAlreadyExistsException extends RuntimeException{
	public IdAlreadyExistsException(String message) {
		super(message);
	}
}
