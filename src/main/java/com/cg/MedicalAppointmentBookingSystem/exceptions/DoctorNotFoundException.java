package com.cg.MedicalAppointmentBookingSystem.exceptions;
/***
 * DoctorNotFoundException is a custom exception class that extends RuntimeException.
 *
 * @author Subhranil
 */
public class DoctorNotFoundException extends RuntimeException{
	public DoctorNotFoundException(String message) {
		super(message);
	}
}
