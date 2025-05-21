package com.cg.MedicalAppointmentBookingSystem.entities;


import com.cg.MedicalAppointmentBookingSystem.annotations.*;
import com.cg.MedicalAppointmentBookingSystem.exceptions.*;

import java.util.Iterator;
import java.util.List;

/***
 * Admin class represents an admin in the system.
 * It extends the User class and contains specific attributes and methods for admins.
 * It contains the overridden method showProfile() to display the admin's profile.
 * @author Subhojeet
 */
@Security(role = "Admin")
public class Admin extends User {
	private String password;

	public Admin() {
	}
	/***
	 * Constructor to create an admin with ID, name, and password.
	 * @param id The ID of the admin. 
	 * @param name The name of the admin.
	 * @param password The password of the admin.
	 */
	public Admin(String id, String name, String password) {
		super(id, name);
		this.password = password;
	}
	/***
	 * 
	 * @return the password of the admin.
	 */
	public String getPassword() {
		return password;
	}
	/***
	 * 
	 * @param password The password of the admin.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/***
	 * 
	 * @return the String of admin details.
	 */
	@Override
	public String showProfile() {
		String adminDetails="Admin ID: " + id + ", Name: " + name;
		System.out.println(adminDetails);
		return adminDetails;
	}
	
	/***
	 * 
	 * @param inputPassword
	 * @return true if the password is correct, false otherwise.
	 */
	// Verifies the admin password.
	public boolean verifyPassword(String inputPassword) {
		return this.password.equals(inputPassword);
	}

	/**
	 * Removes a doctor from the list if admin privileges are verified.
	 * @param doctors The list of doctors.
	 * @param doctorId The ID of the doctor to be removed.
	 */
	public void removeDoctor(List<Doctor> doctors, String doctorId) {
		Security security = this.getClass().getAnnotation(Security.class);
		if (security != null && "Admin".equals(security.role())) {
//			boolean found = false;
//			Iterator<Doctor> iterator = doctors.iterator();
//			while (iterator.hasNext()) {
//				Doctor doctor = iterator.next();
//				if (doctor.getId().equals(doctorId)) {
//					iterator.remove();
//					found = true;
//					System.out.println("Doctor with ID " + doctorId + " removed.");
//					break;
//				}
//			}
			
			Doctor doctor=null;
			//Using stream API to find the doctor with the doctor ID
			doctor=doctors.stream().filter(d->d.getId().equals(doctorId)).findFirst().orElse(null);
			
			if (doctor==null) {
				System.err.println("Doctor with ID " + doctorId + " not found.");
			}else {
				doctors.remove(doctor);
				System.out.println("Doctor with ID " + doctorId + " removed.");
			}
		} else {
			throw new AdminNotFoundException("Unauthorized: Not an admin.");
		}
	}
}