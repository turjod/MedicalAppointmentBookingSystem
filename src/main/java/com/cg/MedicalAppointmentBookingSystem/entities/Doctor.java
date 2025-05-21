package com.cg.MedicalAppointmentBookingSystem.entities;
/**
 * Doctor class represents a doctor in the system.
 * It extends the User class and contains specific attributes and methods for doctors.
 * It contains the overridden method showProfile() to display the doctor's profile.
 *
 * @author Suchismita
 */
public class Doctor extends User {
	/***
	 * Doctor class represents a doctor in the system.
	 */
	private boolean available = true;

	public Doctor() {
	}
	
	/***
	 * Constructor to create a doctor with ID and name.
	 * @param id The ID of the doctor.
	 * @param name The name of the doctor.
	 */
	public Doctor(String id, String name) {
		super(id, name);
	}
	
	/***
	 * 
	 * @return the ID of the doctor.
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/***
	 * 
	 * @param available The availability status of the doctor.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	/***
	 * 
	 * @return the String of doctor details.
	 */
	@Override
	public String showProfile() {
		String doctorDetails="Doctor ID: " + id + ", Doctor Name: " + name + ", Available: " + available;
		System.out.println(doctorDetails);
		return doctorDetails;
	}
}
